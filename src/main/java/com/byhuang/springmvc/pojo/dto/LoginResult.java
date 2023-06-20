package com.byhuang.springmvc.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author huangbingyi
 * @version 1.0
 * @date 2023/6/18 20:09
 * @description 登录结果DTO
 */
@AllArgsConstructor
@Data
public class LoginResult {

    public LoginResult() {

    }

    private String retMsg;

    private boolean flag;
}
