package com.controller;

import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired(required = false)
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Map login(String username, String password) {
        Map<String, Object> map = new HashMap<>();
        User newUser = userService.login(username, password);
        if (newUser != null) {
            if (newUser.getIsAdmin() == 1) {
                map.put("status", "ok");
                map.put("info", 1);//1为管理员
            } else if (newUser.getIsSeller() == 1) {
                map.put("status", "ok");
                map.put("info", 2);//2为商家
            } else if (newUser.getIsVip() == 1) {
                map.put("status", "ok");
                map.put("info", 3);//3为vip
            } else {
                map.put("status", "yes");
                map.put("info", 0);//0为普通用户
            }
        }else{
            map.put("status", "no");//用户不存在
            map.put("info", -1);//-1为用户不存在
        }
        return map;
    }

    @RequestMapping(value = "/registered", method = RequestMethod.GET)
    public Map login(User user){
        int isOk = userService.insertSelective(user);
        Map<String ,Object> map = new HashMap<>();
        if (isOk>0){
            map.put("status", "ok");
            map.put("info", 1);//1代表注册成功
        }else {
            map.put("status", "no");
            map.put("info", -1);//1代表注册失败
        }
        return map;
    }
}
