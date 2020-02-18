package nju.service.impl;

import nju.dao.UserDao;
import nju.service.UserService;
import nju.vo.Result;
import nju.vo.ResultCode;
import nju.vo.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Arthur
 * @Date 2019/10/24 9:30
 */

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;

    Map<String, String> map = new HashMap<>();

//    @Override
//    public Map<String, String> login(String userName, String password) {
//        UserInfo userInfo = userDao.getUserInfo(userName, password);
//        if (null == userInfo)
//            return null;
//
////        return (userInfo.getUserName().equals(userName) && userInfo.getPassword().equals(password));
//        map.put("userName", userInfo.getUserName());
//        map.put("subsidiary", userInfo.getSubsidiary());
//        map.put("role", userInfo.getRole());
//        map.put("level", userInfo.getLevel());
//        map.put("remark", userInfo.getRemark());
//
//        return map;
//    }


    @Override
    public Result login(String userName, String password) {
        UserInfo userInfo = userDao.getUserInfo(userName, password);
        if (null == userInfo)
            return Result.failure(ResultCode.USER_LOGIN_ERROR);

        map.put("userName", userInfo.getUserName());
        map.put("subsidiary", userInfo.getSubsidiary());
        map.put("role", userInfo.getRole());
        map.put("level", userInfo.getLevel());
        map.put("remark", userInfo.getRemark());

        return Result.success(map);
    }
}
