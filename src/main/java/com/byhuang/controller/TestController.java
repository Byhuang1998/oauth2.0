package com.byhuang.controller;

import com.byhuang.pojo.entity.User;
import com.byhuang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public User hello() {
        return userService.selectUserByName("by");
    }
}
