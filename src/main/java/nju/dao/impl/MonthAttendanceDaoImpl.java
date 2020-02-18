package nju.dao.impl;

import nju.dao.MonthAttendanceDao;
import nju.util.Constants;
import nju.util.Utils;
import nju.vo.MonthAttendance;
import nju.vo.Result;
import nju.vo.ResultCode;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author Arthur
 * @Date 2019/10/28 10:37
 */

@Repository
public class MonthAttendanceDaoImpl implements MonthAttendanceDao {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private MongoClient mongoClient = new MongoClient();
    private MongoDatabase mongoDatabase = mongoClient.getDatabase(Constants.DATABASE_NAME);
    private MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(Constants.ATTENDANCE_INFO_);

//    @Override
//    public List<MonthAttendance> getMonthAttendance(Map<String, String> map) {
//        try {
//            Document condition = new Document();
//            condition.append("subsidiary", map.get("subsidiary")).append("relevantPeople", map.get("relevantPeople"))
//                    .append("year", map.get("year"));
//            MongoCursor<Document> cursor = mongoCollection.find(condition).iterator();
//            List<MonthAttendance> list = new ArrayList<>();
//
//            while (cursor.hasNext()) {
//                Document temp = cursor.next();
//                list.add(toMonthAttendance(temp));
//            }
//
//            return list;
//        } catch (Exception e) {
//            logger.error(e.toString() + "_" + e.getMessage(), e);
//        }
//        return null;
//    }


    @Override
    public MonthAttendance getMonthAttendance(Map<String, String> map) {

        try {
            Document condition = new Document();
            condition.append("subsidiary", map.get("subsidiary")).append("relevantPeople", map.get("relevantPeople"))
                    .append("year", map.get("year"));
            MongoCursor<Document> cursor = mongoCollection.find(condition).iterator();

            while (cursor.hasNext()) {
                Document temp = cursor.next();
                return toMonthAttendance(temp);
            }
        } catch (Exception e) {
            logger.error(e.toString() + "_" + e.getMessage(), e);
        }

        return null;
    }

    @Override
    public Result addMonthAttendance(Map<String, Object> map) {

        Result result = new Result();

        try {
            Document condition = new Document();
            condition.append("subsidiary", map.get("subsidiary").toString())
                    .append("relevantPeople", map.get("relevantPeople").toString())
                    .append("year", map.get("year").toString());
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
            logger.error(e.toString() + "_" + e.getMessage());
            result.setResultCode(ResultCode.FAILURE);
        }
        return result;
    }

//    @Override
//    public Result updateMonthAttendance(Map<String, Object> map) {
//        try {
//            Document condition = new Document();
//            condition.append("subsidiary", map.get("subsidiary").toString())
//                    .append("relevantPeople", map.get("relevantPeople").toString())
//                    .append("year", map.get("year").toString());
//
//            mongoCollection.findOneAndUpdate(condition, new Document("$set", toDocument(map)));
//        } catch (Exception e) {
//            logger.error(e.toString() + "_" + e.getMessage(), e);
//        }
//    }

    private static Document toDocument(Map<String, Object> map) {
        Document document = new Document();

        document.put("subsidiary", map.get("subsidiary").toString());
        document.put("relevantPeople", map.get("relevantPeople").toString());
        document.put("auditor", map.get("auditor").toString());
        document.put("principal", map.get("principal").toString());
        document.put("year", map.get("year").toString());
        List<String> datas = (List<String>) map.get("datas");
        document.put("dataSize", datas.size());
        for (int i=0; i<datas.size(); i++) {
            document.put(Integer.toString(i + 1), datas.get(i));
        }

        return document;
    }

    private static MonthAttendance toMonthAttendance(Document document) {
        MonthAttendance monthAttendance = new MonthAttendance();

        monthAttendance.setSubsidiary(document.getString("subsidiary"));
        monthAttendance.setRelevantPeople(document.getString("relevantPeople"));
        monthAttendance.setAuditor(document.getString("auditor"));
        monthAttendance.setPrincipal(document.getString("principal"));
        monthAttendance.setYear(document.getString("year"));
        int dataSize = document.getInteger("dataSize");
        List<String> list = new ArrayList<>();
        // doc的个数减去一个数据库自带的_id和几个固定字段,剩下的都是当月的考勤数据
        for (int i=0; i<dataSize; i++) {
            list.add(Utils.getString(document, Integer.toString(i + 1)));
        }
        monthAttendance.setDatas(list);

        return monthAttendance;
    }
}
