package nju.service;

import nju.vo.Result;
import nju.vo.WeekWorkReport;

import java.util.Map;

/**
 * @Author Arthur
 * @Date 2019/10/25 14:49
 */
public interface WeekWorkContentService {

    //    List<WeekWorkReport> getWeekWorkReportInfo(Map<String, String> map);
    WeekWorkReport getWeekWorkReportInfo(Map<String, String> map);

    Result addWeekWorkReportInfo(Map<String, String> map);
//    void updateWeekWorkReportInfo(Map<String, String> map);
}
