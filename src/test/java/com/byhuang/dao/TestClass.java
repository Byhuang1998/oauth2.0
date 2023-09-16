package com.byhuang.dao;

import com.byhuang.LoginDTO;
import com.byhuang.pojo.entity.User;
import com.byhuang.utils.JWTUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
public class TestClass {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    public void testSelectUserByName() {
        User by = userDao.selectUserByName("by");
        System.out.println(by.toString());
    }

    @Test
    public void testRedisTemplate() {
        redisTemplate.opsForValue().set("key", "value");

        String value = redisTemplate.opsForValue().get("key");
        System.out.println(value);
    }

    @Test
    public void testBCryptPasswordEncoder() {
        String encode = bCryptPasswordEncoder.encode("123456");
        System.out.println("encode: " + encode);
        boolean matches = bCryptPasswordEncoder.matches("123456", encode);
        System.out.println(matches);
    }

    @Test
    public void testJwtUtils() {
        User user = new User();
        user.setId("1");
        user.setName("by");
        user.setPassword("123456");
        LoginDTO dto = new LoginDTO(user);
        String token = JWTUtils.generateToken(dto);
        System.out.println(token);

        boolean flag = JWTUtils.validateToken(token);
        System.out.println(flag);
    }

}
