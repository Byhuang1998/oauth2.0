package com.byhuang.session.dao;

import com.byhuang.session.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Objects;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @date 2023/6/18 14:18
 * @description 登录数据访问层
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User selectUserByName(String username) throws SQLException {
        String sql = "select * from user where username = ?;";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), "张三");
        if (Objects.isNull(user)) {
            throw new RuntimeException("User is not exists");
        }
        return user;
    }

}
