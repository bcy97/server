package nju.service.impl;

import nju.dao.MonthAttendanceDao;
import nju.service.MonthAttendanceService;
import nju.vo.MonthAttendance;
import nju.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author Arthur
 * @Date 2019/10/28 10:58
 */

@Service
public class MonthAttendanceServiceImpl implements MonthAttendanceService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MonthAttendanceDao monthAttendanceDao;

//    @Override
//    public List<MonthAttendance> getMonthAttendance(Map<String, String> map) {
//        if (null == monthAttendanceDao.getMonthAttendance(map))
//            return null;
//
//        return monthAttendanceDao.getMonthAttendance(map);
//    }


    @Override
    public MonthAttendance getMonthAttendance(Map<String, String> map) {
        if (null == monthAttendanceDao.getMonthAttendance(map))
            return null;

        return monthAttendanceDao.getMonthAttendance(map);
    }

    @Override
    public Result addMonthAttendance(Map<String, Object> map) {
        return monthAttendanceDao.addMonthAttendance(map);
    }

//    @Override
//    public void updateMonthAttendance(Map<String, Object> map) {
//        monthAttendanceDao.updateMonthAttendance(map);
//    }
}
