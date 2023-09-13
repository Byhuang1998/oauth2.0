package com.byhuang.dao;

import com.byhuang.pojo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
public class TestUserDao {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    public void testSelectUserByName() {
        User by = userDao.selectUserByName("by");
        System.out.println(by.toString());
    }

    @Test
    public void testBCryptPasswordEncoder() {
        String encode = bCryptPasswordEncoder.encode("123456");
        System.out.println("encode: " + encode);
        boolean matches = bCryptPasswordEncoder.matches("123456", encode);
        System.out.println(matches);
    }

}
