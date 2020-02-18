package nju.dao.impl;

import nju.dao.LeaveDao;
import nju.util.Constants;
import nju.vo.Leave;
import nju.vo.Result;
import nju.vo.ResultCode;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author Arthur
 * @Date 2019/10/25 13:14
 */

@Repository
public class LeaveDaoImpl implements LeaveDao {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private MongoClient mongoClient = new MongoClient();
    private MongoDatabase mongoDatabase = mongoClient.getDatabase(Constants.DATABASE_NAME);
    private MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(Constants.SICK_NOTE_);

    @Override
    public List<Leave> getLeaveInfo(String userName) {

        try {
            Document condition = new Document();
            condition.append("relevantPeople", userName);
            MongoCursor<Document> cursor = mongoCollection.find(condition).iterator();
            List<Leave> list = new ArrayList<>();

            while (cursor.hasNext()) {
                Document temp = cursor.next();
                list.add(toLeave(temp));
            }

            return list;
        } catch (Exception e) {
            logger.error(e.toString() + "_" + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public Result addLeaveInfo(Map<String, String> map) {

        Result result = new Result();

        try {
            mongoCollection.insertOne(toDocument(map));
            result.setResultCode(ResultCode.SUCCESS_ADD);
            return result;
        } catch (Exception e) {
            logger.error(e.toString() + "_" + e.getMessage(), e);
            result.setResultCode(ResultCode.FAILURE_ADD);
        }
        return result;
    }

    @Override
    public Result deleteLeaveInfo(String id) {

        Result result = new Result();

        try {
            mongoCollection.deleteOne(new Document("_id", new ObjectId(id)));
            result.setResultCode(ResultCode.SUCCESS_DELETE);
            return result;
        } catch (Exception e) {
            logger.error(e.toString() + "_" + e.getMessage(), e);
            result.setResultCode(ResultCode.FAILURE_DELETE);
        }
        return result;
    }

    @Override
    public Result updateLeaveInfo(Map<String, String> map) {

        Result result = new Result();

        try {
            mongoCollection.updateOne(new Document("_id", new ObjectId(map.get("id"))), new Document("$set", toDocument(map)));
            result.setResultCode(ResultCode.SUCCESS_UPDATE);
            return result;
        } catch (Exception e) {
            logger.error(e.toString() + "_" + e.getMessage(), e);
            result.setResultCode(ResultCode.FAILURE_UPDATE);
        }
        return result;
    }

    public static Document toDocument(Map<String, String> map) {
        Document document = new Document();

        document.put("subsidiary", map.get("subsidiary"));
        document.put("relevantPeople", map.get("relevantPeople"));
        document.put("type", map.get("type"));
        document.put("startTime", map.get("startTime"));
        document.put("endTime", map.get("endTime"));
        document.put("remark", map.get("remark"));

        return document;
    }

    public static Leave toLeave(Document doc) {
        Leave leave = new Leave();

        leave.setId(doc.getObjectId("_id").toString());
        leave.setSubsidiary(doc.getString("subsidiary"));
        leave.setRelevantPeople(doc.getString("relevantPeople"));
        leave.setType(doc.getString("type"));
        leave.setStartTime(doc.getString("startTime"));
        leave.setEndTime(doc.getString("endTime"));
        leave.setRatify(doc.getString("ratify"));
        leave.setRemark(doc.getString("remark"));

        return leave;
    }
}
