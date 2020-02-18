package nju.dao;

import nju.vo.Result;
import nju.vo.WeekWorkReport;

import java.util.Map;

/**
 * @Author Arthur
 * @Date 2019/10/25 14:25
 */
public interface WeekWorkReportDao {

    //    List<WeekWorkReport> getWeekWorkReport(Map<String, String> map);
    WeekWorkReport getWeekWorkReport(Map<String, String> map);

    Result addWeekWorkReport(Map<String, String> map);
//    void updateWeekWorkReport(Map<String, String> map);
}
