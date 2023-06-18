package com.byhuang;

import com.byhuang.session.pojo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author huangbingyi
 * @version 1.0
 * @date 2023/6/18 18:37
 * @description 数据库操作测试类
 */
@SpringBootTest
public class DatabaseTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testInsert() {
        String sql = "insert into user values(?, ?);";
        jdbcTemplate.update(sql, "tom", "123");
    }

    @Test
    public void testSelectAll() {
        String sql = "select * from user;";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        System.out.println(userList);
    }

    @Test
    public void testSelectOne() {
        String sql = "select * from user where username = ?;";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), "张三");
        System.out.println(user);
    }
}
