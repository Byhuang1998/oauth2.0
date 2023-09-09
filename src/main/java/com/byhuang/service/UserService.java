package com.byhuang.service;

import com.byhuang.dao.UserDao;
import com.byhuang.pojo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author huangbingyi
 * @version 1.0
 * @date 2023/6/18 19:50
 * @description TODO
 */
@Service
public class UserService {
    
    @Autowired
    private UserDao userDao;
    
    public User selectUserByName(String username) {
        User user = userDao.selectUserByName(username);
        if (Objects.isNull(user)) {
            throw new RuntimeException("User is not exists");
        }
        return user;
    }
}
