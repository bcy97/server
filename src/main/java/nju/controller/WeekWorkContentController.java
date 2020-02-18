package nju.controller;

import nju.service.WeekWorkContentService;
import nju.vo.Result;
import nju.vo.WeekWorkReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author Arthur
 * @Date 2019/10/25 14:52
 */

@RestController
@RequestMapping(value = "/weekWorkContent")
public class WeekWorkContentController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WeekWorkContentService workContentService;

    /**
     * url : http://localhost:8888/weekWorkContent/getWeekWorkContent
     * body : {
     *     "year" : "2019",
     *     "weeklyNum" : "44",
     *     "relevantPeople" : "jack"
     * }
     *
     * @return :
     * {
     *   "subsidiary": "南京",
     *   "relevantPeople": "jack",
     *   "principal": "",
     *   "year": "2018",
     *   "weeklyNum": 44,
     *   "mondayWorkContent": "事假",
     *   "tuesdayWorkContent": "事假",
     *   "wednesdayWorkContent": "工作",
     *   "thursdayWorkContent": "工作",
     *   "fridayWorkContent": "工作",
     *   "saturdayWorkContent": "加班",
     *   "sundayWorkContent": "周日"
     * }
     * */

//    @RequestMapping(value = "/getWeekWorkContent")
//    public List<WeekWorkReport> getWeekWorkContent(@RequestBody Map<String, String> map) {
//        return workContentService.getWeekWorkReportInfo(map);
//    }
    @RequestMapping(value = "/getWeekWorkContent")
    public WeekWorkReport getWeekWorkContent(@RequestBody Map<String, String> map) {
        return workContentService.getWeekWorkReportInfo(map);
    }


    /**
     * 此接口包含两种功能:添加和更新
     * url : http://localhost:8888/weekWorkContent/addWeekWorkContent
     * body : {
     *     "subsidiary": "南京",
     *     "relevantPeople": "jack",
     *     "principal": "",
     *     "year": "2018",
     *     "weeklyNum": 44,
     *     "mondayWorkContent": "工作",
     *     "tuesdayWorkContent": "工作",
     *     "wednesdayWorkContent": "事假",
     *     "thursdayWorkContent": "工作",
     *     "fridayWorkContent": "工作",
     *     "saturdayWorkContent": "周六",
     *     "sundayWorkContent": "周日"
     * }
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
     * {
     *   "code": 101,
     *   "msg": "更新成功",
     *   "data": null
     * }
     * */

    @RequestMapping(value = "/addWeekWorkContent")
    public Result addWeekWorkContent(@RequestBody Map<String, String> map) {
        return workContentService.addWeekWorkReportInfo(map);
    }


    /**
     * url : http://localhost:8888/weekWorkContent/updateWeekWorkContent
     * body : {
     *     "subsidiary": "南京",
     *     "relevantPeople": "jack",
     *     "principal": "",
     *     "year": "2018",
     *     "weeklyNum": 44,
     *     "mondayWorkContent": "事假",
     *     "tuesdayWorkContent": "事假",
     *     "wednesdayWorkContent": "工作",
     *     "thursdayWorkContent": "工作",
     *     "fridayWorkContent": "工作",
     *     "saturdayWorkContent": "加班",
     *     "sundayWorkContent": "周日"
     * }
     *
     * @return none
     * */

//    @RequestMapping(value = "/updateWeekWorkContent")
//    public void updateWeekWorkContent(@RequestBody Map<String, String> map) {
//        workContentService.updateWeekWorkReportInfo(map);
//    }

}
