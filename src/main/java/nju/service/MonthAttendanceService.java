package nju.service;

import nju.vo.MonthAttendance;
import nju.vo.Result;

import java.util.Map;

/**
 * @Author Arthur
 * @Date 2019/10/28 10:56
 */
public interface MonthAttendanceService {

    //    List<MonthAttendance> getMonthAttendance(Map<String, String> map);
    MonthAttendance getMonthAttendance(Map<String, String> map);

    Result addMonthAttendance(Map<String, Object> map);
//    void updateMonthAttendance(Map<String, Object> map);

}
