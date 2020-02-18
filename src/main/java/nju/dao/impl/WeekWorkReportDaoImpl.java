package nju.dao.impl;

import nju.dao.WeekWorkReportDao;
import nju.util.Constants;
import nju.vo.Result;
import nju.vo.ResultCode;
import nju.vo.WeekWorkReport;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @Author Arthur
 * @Date 2019/10/25 14:38
 */

@Repository
public class WeekWorkReportDaoImpl implements WeekWorkReportDao {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private MongoClient mongoClient = new MongoClient();
    private MongoDatabase mongoDatabase = mongoClient.getDatabase(Constants.DATABASE_NAME);
    private MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(Constants.WEEKLY_WORK_REPORT_);

//    @Override
//    public List<WeekWorkReport> getWeekWorkReport(Map<String, String> map) {
//
//        try {
//            Document condition = new Document();
//            condition.append("year", map.get("year")).append("weeklyNum", Integer.parseInt(map.get("weeklyNum")))
//                    .append("relevantPeople", map.get("relevantPeople"));
//            MongoCursor<Document> cursor = mongoCollection.find(condition).iterator();
//            List<WeekWorkReport> list = new ArrayList<>();
//
//            while (cursor.hasNext()) {
//                Document temp = cursor.next();
//                list.add(toWeekWorkContent(temp));
//            }
//
//            return list;
//        } catch (Exception e) {
//            logger.error(e.toString() + "_" + e.getMessage(), e);
//        }
//        return null;
//    }


    @Override
    public WeekWorkReport getWeekWorkReport(Map<String, String> map) {

        try {
            WeekWorkReport workReport;
            Document condition = new Document();
            condition.append("year", map.get("year")).append("weeklyNum", Integer.parseInt(map.get("weeklyNum")))
                    .append("relevantPeople", map.get("relevantPeople"));
            MongoCursor<Document> cursor = mongoCollection.find(condition).iterator();

            while (cursor.hasNext()) {
                Document temp = cursor.next();
                return toWeekWorkContent(temp);
            }
        } catch (Exception e) {
            logger.error(e.toString() + "_" + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public Result addWeekWorkReport(Map<String, String> map) {

        Result result = new Result();

        try {
            Document condition = new Document();
            condition.append("year", map.get("year")).append("weeklyNum", Integer.parseInt(map.get("weeklyNum")))
                    .append("relevantPeople", map.get("relevantPeople"));
            MongoCursor<Document> cursor = mongoCollection.find(condition).iterator();

            if (!cursor.hasNext()) {
                mongoCollection.insertOne(toDocument(map));
                result.setResultCode(ResultCode.SUCCESS_ADD);
                return result;
            } else {
                mongoCollection.findOneAndUpdate(condition, new Document("$set", toDocument(map)));
                result.setResultCode(ResultCode.SUCCESS_UPDATE);
                return result;
            }
        } catch (Exception e) {
            logger.error(e.toString() + "_" + e.getMessage(), e);
            result.setResultCode(ResultCode.FAILURE);
        }
        return result;
    }

//    @Override
//    public void updateWeekWorkReport(Map<String, String> map) {
//
//        try {
//            Document obj = new Document();
//            obj.append("year", map.get("year")).append("weeklyNum", Integer.parseInt(map.get("weeklyNum")))
//                    .append("relevantPeople", map.get("relevantPeople"));
//            mongoCollection.findOneAndUpdate(obj, new BasicDBObject("$set", toDocument(map)), new FindOneAndUpdateOptions().upsert(true));
//        } catch (Exception e) {
//            logger.error(e.toString() + "_" + e.getMessage(), e);
//        }
//    }

    public static Document toDocument(Map<String, String> map) {
        Document document = new Document();

        document.put("subsidiary", map.get("subsidiary"));
        document.put("relevantPeople", map.get("relevantPeople"));
        document.put("year", map.get("year"));
        document.put("weeklyNum", Integer.parseInt(map.get("weeklyNum")));
        document.put("mondayWorkContent", map.get("mondayWorkContent"));
        document.put("tuesdayWorkContent", map.get("tuesdayWorkContent"));
        document.put("wednesdayWorkContent", map.get("wednesdayWorkContent"));
        document.put("thursdayWorkContent", map.get("thursdayWorkContent"));
        document.put("fridayWorkContent", map.get("fridayWorkContent"));
        document.put("saturdayWorkContent", map.get("saturdayWorkContent"));
        document.put("sundayWorkContent", map.get("sundayWorkContent"));

        return document;
    }

    public static WeekWorkReport toWeekWorkContent(Document document) {
        WeekWorkReport weekWorkReport = new WeekWorkReport();

        weekWorkReport.setSubsidiary(document.getString("subsidiary"));
        weekWorkReport.setRelevantPeople(document.getString("relevantPeople"));
        weekWorkReport.setPrincipal(document.getString("principal"));
        weekWorkReport.setYear(document.getString("year"));
        weekWorkReport.setWeeklyNum(document.getInteger("weeklyNum"));
        weekWorkReport.setMondayWorkContent(document.getString("mondayWorkContent"));
        weekWorkReport.setTuesdayWorkContent(document.getString("tuesdayWorkContent"));
        weekWorkReport.setWednesdayWorkContent(document.getString("wednesdayWorkContent"));
        weekWorkReport.setThursdayWorkContent(document.getString("thursdayWorkContent"));
        weekWorkReport.setFridayWorkContent(document.getString("fridayWorkContent"));
        weekWorkReport.setSaturdayWorkContent(document.getString("saturdayWorkContent"));
        weekWorkReport.setSundayWorkContent(document.getString("sundayWorkContent"));

        return weekWorkReport;
    }
}
