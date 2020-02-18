package nju.dao.impl;

import nju.dao.CarUseDao;
import nju.util.Constants;
import nju.vo.CarUse;
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
 * @Date 2019/10/24 13:23
 */

@Repository
public class CarUseDaoImpl implements CarUseDao {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private MongoClient mongoClient = new MongoClient();
    private MongoDatabase mongoDatabase = mongoClient.getDatabase(Constants.DATABASE_NAME);
    private MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(Constants.CAR_RECORD_);

    @Override
    public List<CarUse> getCarUseInfo(String userName) {

        try {
//            MongoClient mongoClient = new MongoClient();
//            MongoDatabase mongoDatabase = mongoClient.getDatabase(Constants.DATABASE_NAME);
//            MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(Constants.CAR_RECORD_);
            Document condition = new Document();
            condition.append("user", userName);
            MongoCursor<Document> cursor = mongoCollection.find(condition).iterator();
            List<CarUse> list = new ArrayList<>();

            while (cursor.hasNext()) {
                Document temp = cursor.next();
                list.add(toCarUse(temp));
            }

            return list;
        } catch (Exception e) {
            logger.error(e.toString() + "_" + e.getMessage(), e);
        }
        return null;
    }

//    @Override
//    public void addCarUseInfo(Map<String, String> map) {
//        try {
//            mongoCollection.insertOne(toDocument(map));
//        } catch (Exception e) {
//            logger.error(e.toString() + "_" + e.getMessage(), e);
//        }
//    }
//
//    @Override
//    public void updateCarUseInfo(Map<String, String> map) {
//        try {
//            mongoCollection.updateOne(new Document("_id", new ObjectId(map.get("id"))), new Document("$set", toDocument(map)));
//        } catch (Exception e) {
//            logger.error(e.toString() + "_" + e.getMessage(), e);
//        }
//    }


//    @Override
//    public void addCarUseInfo(Map<String, String> map) {
//        try {
//            if (null != map.get("id")) {
//                mongoCollection.updateOne(new Document("_id", new ObjectId(map.get("id"))), new Document("$set", toDocument(map)));
//            } else {
//                mongoCollection.insertOne(toDocument(map));
//            }
//        } catch (Exception e) {
//            logger.error(e.toString() + "_" + e.getMessage(), e);
//        }
//    }


    @Override
    public Result addCarUseInfo(Map<String, String> map) {

        Result result = new Result();

        try {
            if (null != map.get("id")) {
                mongoCollection.updateOne(new Document("_id", new ObjectId(map.get("id"))), new Document("$set", toDocument(map)));
                result.setResultCode(ResultCode.SUCCESS_UPDATE);
                return result;
            } else {
                mongoCollection.insertOne(toDocument(map));
                result.setResultCode(ResultCode.SUCCESS_ADD);
                return result;
            }
        } catch (Exception e) {
            logger.error(e.toString() + "_" + e.getMessage(), e);
            result.setResultCode(ResultCode.FAILURE);
        }

        return result;
    }

//    @Override
//    public void deleteCarUseInfo(String id) {
//        try {
//            mongoCollection.deleteOne(new Document("_id", new ObjectId(id)));
//        } catch (Exception e) {
//            logger.error(e.toString() + "_" + e.getMessage(), e);
//        }
//    }


    @Override
    public Result deleteCarUseInfo(String id) {

        Result result = new Result();

        try {
            mongoCollection.deleteOne(new Document("_id", new ObjectId(id)));
            result.setResultCode(ResultCode.SUCCESS_DELETE);
            return result;
        } catch (Exception e) {
            logger.error(e.toString() + "_" + e.getMessage(), e);
            result.setResultCode(ResultCode.FAILURE);
        }
        return result;
    }

    public static Document toDocument(Map<String, String> map) {
        Document document = new Document();

        document.put("subsidiary", map.get("subsidiary"));
        document.put("carNo", map.get("carNo"));
        document.put("date", map.get("date"));
        document.put("startMileage", Integer.parseInt(map.get("startMileage")));
        document.put("endMileage", Integer.parseInt(map.get("endMileage")));
        document.put("useMileage", Integer.parseInt(map.get("useMileage")));
        document.put("useReason", map.get("useReason"));
        document.put("isPrivateUse", Boolean.parseBoolean(map.get("isPrivateUse")));
        document.put("user", map.get("user"));

        return document;
    }

    public static CarUse toCarUse(Document document) {
        CarUse carUse = new CarUse();

        carUse.setId(document.getObjectId("_id").toString());
        carUse.setSubsidiary(document.getString("subsidiary"));
        carUse.setCarNo(document.getString("carNo"));
        carUse.setDate(document.getString("date"));
        carUse.setStartMileage(document.getInteger("startMileage"));
        carUse.setEndMileage(document.getInteger("endMileage"));
        carUse.setUseMileage(document.getInteger("useMileage"));
        carUse.setUseReason(document.getString("useReason"));
        carUse.setPrivateUse(document.getBoolean("isPrivateUse"));
        carUse.setUser(document.getString("user"));
        carUse.setRatify(document.getString("ratify"));

        return carUse;
    }
}
