package nju.service;

import nju.vo.Leave;
import nju.vo.Result;

import java.util.List;
import java.util.Map;

/**
 * @Author Arthur
 * @Date 2019/10/25 13:28
 */
public interface LeaveService {

    List<Leave> getLeaveInfo(String userName);

    Result addLeaveInfo(Map<String, String> map);

    Result deleteLeaveInfo(String id);

    Result updateLeaveInfo(Map<String, String> map);
}
