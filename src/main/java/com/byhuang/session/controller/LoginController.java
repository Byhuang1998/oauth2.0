package com.byhuang.session.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @date 2023/6/18 14:17
 * @description 登录控制器
 */
@RestController
public class LoginController {

    @RequestMapping("/login")
    public String login() {

        return null;
    }
}
