package com.byhuang.controller;

import com.byhuang.pojo.entity.User;
import com.byhuang.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        return loginService.login(user);

    }

    @PostMapping("/logout")
    public String logout() {
        Boolean logout = loginService.logout();
        return "success";
    }



}
