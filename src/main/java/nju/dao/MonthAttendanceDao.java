package nju.dao;

import nju.vo.MonthAttendance;
import nju.vo.Result;

import java.util.Map;

/**
 * @Author Arthur
 * @Date 2019/10/25 17:04
 */
public interface MonthAttendanceDao {

    //    List<MonthAttendance> getMonthAttendance(Map<String, String> map);
    MonthAttendance getMonthAttendance(Map<String, String> map);

    //    Result updateMonthAttendance(Map<String, Object> map);
    Result addMonthAttendance(Map<String, Object> map);
}
