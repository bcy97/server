package nju.service.impl;

import nju.dao.LeaveDao;
import nju.service.LeaveService;
import nju.vo.Leave;
import nju.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author Arthur
 * @Date 2019/10/25 13:29
 */

@Service
public class LeaveServiceImpl implements LeaveService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LeaveDao leaveDao;

    @Override
    public List<Leave> getLeaveInfo(String userName) {

        if (null == leaveDao.getLeaveInfo(userName))
            return null;

        return leaveDao.getLeaveInfo(userName);
    }

    @Override
    public Result addLeaveInfo(Map<String, String> map) {
        return leaveDao.addLeaveInfo(map);
    }

    @Override
    public Result deleteLeaveInfo(String id) {
        return leaveDao.deleteLeaveInfo(id);
    }

    @Override
    public Result updateLeaveInfo(Map<String, String> map) {
        return leaveDao.updateLeaveInfo(map);
    }
}
