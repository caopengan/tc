package com.simba.auth.controller;

import com.simba.auth.entity.User;
import com.simba.auth.service.UserService;
import com.simba.common.util.UtilDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;

@Controller
public class UserControoler {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public Integer register(String userName,String password,String mobile,String email){
        User user = new User();
        user.setUserName(userName);
        user.setEmail(email);
        user.setPassword(password);
        user.setMobile(mobile);
        Timestamp now = UtilDateTime.nowTimestamp();
        user.setCreateDateTime(now);
        user.setUpdateDateTime(now);
        return userService.addUser(user);
    }

}
