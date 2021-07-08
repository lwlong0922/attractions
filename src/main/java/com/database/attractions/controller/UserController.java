package com.database.attractions.controller;

import com.database.attractions.tool.StatusCode;
import com.database.attractions.bean.User;
import com.database.attractions.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    StatusCode statusCode;

    /**
     * 登录接口
     */
    @GetMapping(path = "/user/login/userid={userid}&password={password}")
    public StatusCode Login(@PathVariable("userid") String userID, @PathVariable("password") String password) {
        User user = userMapper.userLogin(userID, password);
        statusCode.setStatus(200);
        statusCode.setObject(user);
        if (user == null) {
            statusCode.setStatus(500);
            statusCode.setObject(null);
        }
        return statusCode;
    }

    /**
     * 验证账号接口
     */
    @GetMapping(path = "/user/getname/userid={userid}")
    public StatusCode getName(@PathVariable("userid") String userID){
        statusCode.setStatus(200);
        String name=userMapper.getName(userID);
        if (name==null)
            statusCode.setStatus(500);
        statusCode.setObject(name);
        return statusCode;
    }

    /**
     * 注册接口
     */
    @PostMapping(path = "/user/register")
    public StatusCode Register(@RequestBody User user) {
        try {
            statusCode.setStatus(200);
            userMapper.userRegister(user);
            statusCode.setObject(user);
        } catch (Exception exception) {
            statusCode.setStatus(500);
            statusCode.setObject(null);
        }
        return statusCode;
    }

    /**
     * 更新信息接口
     */
    @PostMapping(path = "/user/update")
    public StatusCode Update(@RequestBody User user){
        try {
            statusCode.setStatus(200);
            userMapper.UserUpdate(user);
            statusCode.setObject(user);
        } catch (Exception exception) {
            statusCode.setStatus(500);
            statusCode.setObject(null);
        }
        return statusCode;
    }


}
