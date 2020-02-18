package nju.controller;

import nju.service.CarUseService;
import nju.vo.CarUse;
import nju.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author Arthur
 * @Date 2019/10/24 13:42
 */

@RestController
@RequestMapping(value = "/carUse")
public class CarUseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CarUseService carUseService;

    /**
     * url : http://localhost:8888/carUse/getCarUseInfo
     * body : {
     *     "userName":"jack"
     * }
     *
     * @return : {
     *       {
     *     "id": "5db134398a2700003c003a02",
     *     "subsidiary": "南京",
     *     "carNo": "苏A 88888",
     *     "date": "2019-10-24 12:12:00",
     *     "startMileage": 150000,
     *     "endMileage": 150100,
     *     "useMileage": 100,
     *     "useReason": "港口维修",
     *     "user": "jack",
     *     "ratify": "批准",
     *     "privateUse": false
     *   },
     *   {
     *     "id": "5db13eb216c5ac554e7c466f",
     *     "subsidiary": "广州",
     *     "carNo": "粤A 88888",
     *     "date": "2019-10-1 23:12:45",
     *     "startMileage": 145000,
     *     "endMileage": 146000,
     *     "useMileage": 1000,
     *     "useReason": "电站维修",
     *     "user": "jack",
     *     "ratify": "批准",
     *     "privateUse": false
     *   }
     * } or []
     * */

    @RequestMapping(value = "/getCarUseInfo")
    public List<CarUse> getCarUseInfo(@RequestBody Map<String, String> map) {
        return carUseService.getCarUseInfo(map.get("userName"));
    }


    /**
     * 此接口包含两种功能:添加和更新
     *
     * 添加功能:
     * url : http://localhost:8888/carUse/addCarUseInfo
     * body : {
     *     "subsidiary" : "南京",
     *     "carNo" : "苏A 66666",
     *     "date" : "2019-4-5 18:12:1",
     *     "startMileage" : 165000,
     *     "endMileage" : 166000,
     *     "useMileage" : 1000,
     *     "useReason" : "港口维修",
     *     "isPrivateUse" : false,
     *     "user" : "jack"
     * }
     *
     * @return :
     *      {
     *   "code": 102,
     *   "msg": "添加成功",
     *   "data": null
     * }
     *
     * 更新功能:
     * url : http://localhost:8888/carUse/addCarUseInfo
     * body :   {
     *     "id": "5e1440135778b5219daf4a55",
     *     "subsidiary": "南京",
     *     "carNo": "苏A 88688",
     *     "date": "2020-1-1 23:12:45",
     *     "startMileage": 44000,
     *     "endMileage": 50000,
     *     "useMileage": 6000,
     *     "useReason": "电厂",
     *     "isPrivateUse": false,
     *     "user": "jack"
     *   }
     *
     * @return :
     * {
     *   "code": 101,
     *   "msg": "更新成功",
     *   "data": null
     * }
     * */

    @RequestMapping(value = "/addCarUseInfo")
//    public void addCarUseInfo(@RequestBody Map<String, String> map) {
//        carUseService.addCarUseInfo(map);
//    }
    public Result addCarUseInfo(@RequestBody Map<String, String> map) {
        return carUseService.addCarUseInfo(map);
    }


    /**
     * url : http://localhost:8888/carUse/deleteCarUseInfo
     * body : {
     *     "id" : "5db134398a2700003c003a02"
     * }
     *
     * @return :
     * {
     *   "code": 103,
     *   "msg": "删除成功",
     *   "data": null
     * }
     * */

    @RequestMapping(value = "/deleteCarUseInfo")
    public Result deleteCarUseInfo(@RequestBody Map<String, String> map) {
        return carUseService.deleteUserInfo(map.get("id"));
    }

}
