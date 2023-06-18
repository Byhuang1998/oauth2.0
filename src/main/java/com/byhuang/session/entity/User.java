package com.byhuang.session.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @date 2023/6/18 14:13
 * @description 用户实体类
 */
@AllArgsConstructor
@Data
public class User {

    public User() {

    }

    private String username;
    private String password;
}
