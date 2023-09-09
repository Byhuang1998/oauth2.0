package com.byhuang.dao;

import com.byhuang.pojo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestUserDao {

    @Autowired
    private UserDao userDao;

    @Test
    public void testSelectUserByName() {
        User by = userDao.selectUserByName("by");
        System.out.println(by.toString());
    }

}
