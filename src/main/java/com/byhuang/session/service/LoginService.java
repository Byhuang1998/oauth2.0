package com.byhuang.session.service;

import com.byhuang.session.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @date 2023/6/18 14:17
 * @description 登录服务
 */
@Service
public class LoginService {

    @Autowired
    private UserDao userDao;

    public String login() {
        return null;
    }
}
