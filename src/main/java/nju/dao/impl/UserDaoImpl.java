package nju.dao.impl;

import nju.dao.UserDao;
import nju.util.Constants;
import nju.vo.UserInfo;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @Author Arthur
 * @Date 2019/10/23 16:04
 */

@Repository
public class UserDaoImpl implements UserDao {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private MongoClient mongoClient = new MongoClient();
    private MongoDatabase mongoDatabase = mongoClient.getDatabase(Constants.DATABASE_NAME);
    private MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(Constants.USER_INFO_);

    @Override
    public UserInfo getUserInfo(String userName, String password) {

        try {
            MongoCursor<Document> cursor = mongoCollection.find().iterator();
            UserInfo userInfo = new UserInfo();

            try {
                while (cursor.hasNext()) {
                    Document condition = cursor.next();
                    if (condition.getString("username").equals(userName) && condition.getString("password").equals(password)) {
                        userInfo.setUserName(condition.getString("username"));
                        userInfo.setPassword(condition.getString("password"));
                        userInfo.setSubsidiary(condition.getString("subsidiary"));
                        userInfo.setLevel(condition.getString("level"));
                        userInfo.setRemark(condition.getString("remark"));
                        userInfo.setRole(condition.getString("role"));
                        return userInfo;
                    }
                }
            } finally {
                cursor.close();
            }
        } catch (Exception e) {
            logger.error(e.toString() + "_" + e.getMessage(), e);
        }
        return null;
    }


}
