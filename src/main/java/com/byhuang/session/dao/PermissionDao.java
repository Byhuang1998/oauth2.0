package com.byhuang.session.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author huangbingyi
 * @version 1.0
 * @date 2023/6/18 14:18
 * @description 权限访问层
 */
@Repository
public class PermissionDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<String> listPermission(String uid) {
        String sql = "select resource from permission where uid = ?;";
        return jdbcTemplate.queryForList(sql, String.class, uid);
    }

}
