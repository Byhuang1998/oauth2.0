package com.byhuang.dao;

import com.byhuang.LoginDTO;
import com.byhuang.pojo.entity.Client;
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
    private ClientDao clientDao;

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
    public void testGetClientById() {
        Client client = clientDao.selectClientById("c1");
        System.out.println(client.toString());
    }

    @Test
    public void testRedisTemplate() {
        redisTemplate.opsForValue().set("key", "value");

        String value = redisTemplate.opsForValue().get("key");
        System.out.println(value);
    }

    @Test
    public void testBCryptPasswordEncoder() {
        String encode = bCryptPasswordEncoder.encode("secret");
        System.out.println("encode: " + encode);
        boolean matches = bCryptPasswordEncoder.matches("secret", encode);
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
