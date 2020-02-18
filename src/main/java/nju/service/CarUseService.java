package nju.service;

import nju.vo.CarUse;
import nju.vo.Result;

import java.util.List;
import java.util.Map;

/**
 * @Author Arthur
 * @Date 2019/10/24 13:37
 */
public interface CarUseService {

    List<CarUse> getCarUseInfo(String userName);

    //    void addCarUseInfo(Map<String, String> map);
    Result addCarUseInfo(Map<String, String> map);

    //    void updateUseInfo(Map<String, String> map);
    Result deleteUserInfo(String id);
//    void deleteUserInfo(String id);
}
