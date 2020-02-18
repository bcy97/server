package nju.service.impl;

import nju.dao.CarUseDao;
import nju.service.CarUseService;
import nju.vo.CarUse;
import nju.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author Arthur
 * @Date 2019/10/24 13:38
 */

@Service
public class CarUseServiceImpl implements CarUseService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CarUseDao carUseDao;

    @Override
    public List<CarUse> getCarUseInfo(String userName) {

        if (null == carUseDao.getCarUseInfo(userName))
            return null;

        return carUseDao.getCarUseInfo(userName);
    }

//    @Override
//    public void addCarUseInfo(Map<String, String> map) {
//        carUseDao.addCarUseInfo(map);
//    }

    @Override
    public Result addCarUseInfo(Map<String, String> map) {
//        if (null == carUseDao.addCarUseInfo(map))
//            return Result.failure(ResultCode.FAILURE);
        return carUseDao.addCarUseInfo(map);
    }


//    @Override
//    public void updateUseInfo(Map<String, String> map) {
//        carUseDao.updateCarUseInfo(map);
//    }

    @Override
//    public void deleteUserInfo(String id) {
//        carUseDao.deleteCarUseInfo(id);
//    }
    public Result deleteUserInfo(String id) {
        return carUseDao.deleteCarUseInfo(id);
    }
}
