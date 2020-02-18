package nju.dao;

import nju.vo.UserInfo;

/**
 * @Author Arthur
 * @Date 2019/10/23 15:34
 */
public interface UserDao {

    UserInfo getUserInfo(String userName, String password);

}
