package nju.controller;

import nju.service.MonthAttendanceService;
import nju.vo.MonthAttendance;
import nju.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author Arthur
 * @Date 2019/10/28 11:02
 */

@RestController
@RequestMapping(value = "/monthAttendance")
public class MonthAttendanceController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MonthAttendanceService attendanceService;

    /**
     * url : http://localhost:8888/monthAttendance/getMonthAttendance
     * body : {
     *     "year" : "2019/11",
     *     "subsidiary" : "南京",
     *     "relevantPeople" : "jack"
     * }
     *
     * @return :
     * {
     *   "subsidiary": "南京",
     *   "relevantPeople": "jack",
     *   "auditor": "",
     *   "principal": "",
     *   "year": "2019/11",
     *   "datas": [
     *     "0,0,0,0,0,0,0,0,0",
     *     "0,0,0,0,0,0,0,0,0",
     *     "0,0,0,2.5,0,0,0,0,0",
     *     "0,0,0,0,0,0,0,0,0",
     *     "0,8,5.5,0,0,8,0,0,0",
     *     "0,5.5,2.5,0,0,0,0,0,0",
     *     "5.5,0,0,0,0,0,0,0,8"
     *   ]
     * }
     * */

//    @RequestMapping(value = "/getMonthAttendance")
//    public List<MonthAttendance> getMonthAttendance(@RequestBody Map<String, String> map) {
//        return attendanceService.getMonthAttendance(map);
//    }
    @RequestMapping(value = "/getMonthAttendance")
    public MonthAttendance getMonthAttendance(@RequestBody Map<String, String> map) {
        return attendanceService.getMonthAttendance(map);
    }

    /**
     * 此方法包含添加和更新功能
     * url : http://localhost:8888/monthAttendance/addMonthAttendance
     * body : {
     *     "subsidiary": "南京",
     *     "relevantPeople": "jack",
     *     "auditor": "",
     *     "principal": "",
     *     "year": "2018/12",
     *     "datas": [
     *       "1,0,0,110,11,0,0,0,0",
     *       "0,0,0,0,0,12,0,0,0",
     *       "0,0,0,2.5,0,0,0,0,0",
     *       "0,0,0,0,0,0,0,0,0",
     *       "0,8,0,0,0,8,0,0,0",
     *       "0,0,2.5,0,0,8,0,0,0",
     *       "5.5,0,0,8,0,0,0,0,8"
     *     ]
     *   }
     *
     * @return :
     * {
     *   "code": 102,
     *   "msg": "添加成功",
     *   "data": null
     * }
     *
     * or
     *
     *{
     *   "code": 101,
     *   "msg": "更新成功",
     *   "data": null
     * }
     * */

    @RequestMapping(value = "/addMonthAttendance")
    public Result addMonthAttendance(@RequestBody Map<String, Object> map) {
        return attendanceService.addMonthAttendance(map);
    }


//    @RequestMapping(value = "/updateMonthAttendance")
//    public void updateMonthAttendance(@RequestBody Map<String, Object> map) {
//        attendanceService.updateMonthAttendance(map);
//    }

}
