package nju.controller;

import nju.service.LeaveService;
import nju.vo.Leave;
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
 * @Date 2019/10/25 13:31
 */

@RestController
@RequestMapping(value = "/leave")
public class LeaveController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LeaveService leaveService;

    /**
     * url : http://localhost:8888/leave/getLeaveInfo
     * body : {
     *     "relevantPeople" : "jack"
     * }
     *
     * @return
     *  [
     *   {
     *     "id": "5db283128a2700003c003a03",
     *     "subsidiary": "南京",
     *     "relevantPeople": "jack",
     *     "type": "病假",
     *     "startTime": "2019-10-14 8:10",
     *     "endTime": "2019-10-14 18:30",
     *     "ratify": "",
     *     "remark": "hello"
     *   },
     *   {
     *     "id": "5db289cd8a2700003c003a04",
     *     "subsidiary": "南京",
     *     "relevantPeople": "jack",
     *     "type": "事假",
     *     "startTime": "2019-10-2 8:10",
     *     "endTime": "2019-10-4 18:30",
     *     "ratify": null,
     *     "remark": "world"
     *   }
     * ]
     * */

    @RequestMapping(value = "/getLeaveInfo")
    public List<Leave> getLeaveInfo(@RequestBody Map<String, String> map) {
        return leaveService.getLeaveInfo(map.get("relevantPeople"));
    }

    /**
     * url : http://localhost:8888/leave/addLeaveInfo
     * body : {
     *     "subsidiary" : "南京",
     *     "relevantPeople" : "jack",
     *     "type" : "年假",
     *     "startTime" : "2018-10-8 12:00",
     *     "endTime" : "2018-10-20 12:00",
     *     "remark" : "hello world"
     * }
     *
     * @return :
     * {
     *   "code": 102,
     *   "msg": "添加成功",
     *   "data": null
     * }
     * */

    @RequestMapping(value = "/addLeaveInfo")
    public Result addLeaveInfo(@RequestBody Map<String, String> map) {
        return leaveService.addLeaveInfo(map);
    }

    /**
     * url : http://localhost:8888/leave/deleteLeaveInfo
     * body : {
     *     "id" : "5db28d1abeb1a65d68830532"
     * }
     *
     * @return :
     * {
     *   "code": 103,
     *   "msg": "删除成功",
     *   "data": null
     * }
     * */

    @RequestMapping(value = "deleteLeaveInfo")
    public Result deleteLeaveInfo(@RequestBody Map<String, String> map) {
        return leaveService.deleteLeaveInfo(map.get("id"));
    }


    /**
     * url : http://localhost:8888/leave/updateLeaveInfo
     * body : {
     *     "id": "5db283128a2700003c003a03",
     *     "subsidiary": "广州",
     *     "relevantPeople": "jack",
     *     "type": "年假",
     *     "startTime": "2019-10-14 8:10",
     *     "endTime": "2019-10-14 18:30",
     *     "remark": "fuvk"
     * }
     *
     * @return :
     * {
     *   "code": 101,
     *   "msg": "更新成功",
     *   "data": null
     * }
     * */
    @RequestMapping(value = "updateLeaveInfo")
    public Result updateLeaveInfo(@RequestBody Map<String, String> map) {
        return leaveService.updateLeaveInfo(map);
    }

}
