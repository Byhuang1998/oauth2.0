package com.byhuang.session.dao;

import com.byhuang.session.pojo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author huangbingyi
 * @version 1.0
 * @date 2023/6/18 14:18
 * @description 登录数据访问层
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User selectUserByName(String username) {
        String sql = "select * from user where username = ?;";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username);
    }

}
