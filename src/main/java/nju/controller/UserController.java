package nju.controller;

import nju.service.UserService;
import nju.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author Arthur
 * @Date 2019/10/23 15:33
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    /**
     * api : http://101.132.72.154:8888/user/login
     * body : {
     *      "userName" : jack,
     *      "password" : 123
     * }
     *
     * @return :
     * {
     *   "code": 1,
     *   "msg": "成功",
     *   "data": {
     *     "role": "xxx",
     *     "level": "ooo",
     *     "remark": "hello",
     *     "userName": "jack",
     *     "subsidiary": "南京"
     *   }
     * }
     *
     * or
     *
     * {
     *   "code": 20002,
     *   "msg": "账号不存在或密码错误",
     *   "data": null
     * }
     * */

    @RequestMapping(value = "/login")
//    public Map<String, String> login(@RequestBody Map<String, String> map) {
//        return userService.login(map.get("userName"), map.get("password"));
//    }
    public Result login(@RequestBody Map<String, String> map) {
        return userService.login(map.get("userName"), map.get("password"));
    }

}
