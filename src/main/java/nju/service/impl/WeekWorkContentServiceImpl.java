package nju.service.impl;

import nju.dao.WeekWorkReportDao;
import nju.service.WeekWorkContentService;
import nju.vo.Result;
import nju.vo.WeekWorkReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author Arthur
 * @Date 2019/10/25 14:49
 */

@Service
public class WeekWorkContentServiceImpl implements WeekWorkContentService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WeekWorkReportDao weekWorkReportDao;

//    @Override
//    public List<WeekWorkReport> getWeekWorkReportInfo(Map<String, String> map) {
//
//        if (null == weekWorkReportDao.getWeekWorkReport(map))
//            return null;
//
//        return weekWorkReportDao.getWeekWorkReport(map);
//    }


    @Override
    public WeekWorkReport getWeekWorkReportInfo(Map<String, String> map) {

        if (null == weekWorkReportDao.getWeekWorkReport(map))
            return null;

        return weekWorkReportDao.getWeekWorkReport(map);

    }

    @Override
    public Result addWeekWorkReportInfo(Map<String, String> map) {
        return weekWorkReportDao.addWeekWorkReport(map);
    }

//    @Override
//    public void updateWeekWorkReportInfo(Map<String, String> map) {
//        weekWorkReportDao.updateWeekWorkReport(map);
//    }
}
