package nju.service;

import nju.vo.Result;

/**
 * @Author Arthur
 * @Date 2019/10/24 9:09
 */
public interface UserService {

    //    Map<String, String> login(String userName, String password);
    Result login(String userName, String password);

}
