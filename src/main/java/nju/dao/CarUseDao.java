package nju.dao;

import nju.vo.CarUse;
import nju.vo.Result;

import java.util.List;
import java.util.Map;

/**
 * @Author Arthur
 * @Date 2019/10/24 10:36
 */

public interface CarUseDao {

    List<CarUse> getCarUseInfo(String userName);

    //    void addCarUseInfo(Map<String, String> map);
//    void updateCarUseInfo(Map<String, String> map);
    Result deleteCarUseInfo(String id);

    //    void deleteCarUseInfo(String id);
//    void addCarUseInfo(Map<String, String> map);
    Result addCarUseInfo(Map<String, String> map);
}
