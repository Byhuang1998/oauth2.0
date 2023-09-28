package com.byhuang.dao;

import com.byhuang.pojo.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ClientDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Client selectClientById(String clientId) {
        String sql = "select * from client where client_id = ?;";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Client.class), clientId);
    }
}
