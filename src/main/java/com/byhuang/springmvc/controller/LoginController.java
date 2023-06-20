package com.byhuang.springmvc.controller;

import com.byhuang.springmvc.pojo.dto.LoginDTO;
import com.byhuang.springmvc.pojo.dto.LoginResult;
import com.byhuang.springmvc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author huangbingyi
 * @version 1.0
 * @date 2023/6/18 14:17
 * @description 登录控制器
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;
    
    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO, HttpSession httpSession) {
        LoginResult loginResult = loginService.login(loginDTO);
        if (loginResult.isFlag()) {
            httpSession.setAttribute("user", loginResult);
            return "welcome," + loginResult.getRetMsg();
        }
        return loginResult.getRetMsg();
    }
}
