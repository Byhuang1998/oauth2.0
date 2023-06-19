package com.byhuang.session.service;

import com.byhuang.session.pojo.dto.LoginDTO;
import com.byhuang.session.pojo.dto.LoginResult;
import com.byhuang.session.pojo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author huangbingyi
 * @version 1.0
 * @date 2023/6/18 14:17
 * @description 登录服务
 */
@Service
public class LoginService {

    @Autowired
    private UserService userService;

    public LoginResult login(LoginDTO loginDTO) {
        String username = loginDTO.getUsername();
        User user = userService.selectUserByName(username);
        if (Objects.isNull(user)) {
            return new LoginResult("anonymous", false);
        }
        String password = loginDTO.getPassword();
        if (!checkUsernameAndPassword(password, user.getPassword())) {
            return new LoginResult("username and password don't match", false);
        }
        return new LoginResult(user.getUid(), true);
    }
    
    private boolean checkUsernameAndPassword(String inputPassword, String rightPassword) {
        return inputPassword.equals(rightPassword);
    }
}
