package com.byhuang.session.service;

import org.springframework.stereotype.Service;

/**
 * @author huangbingyi
 * @version 1.0
 * @date 2023/6/18 19:50
 * @description 资源服务
 */
@Service
public class ResourceService {

    public String resourceOne() {
        System.out.println("resource one.");
        return "resource one";
    }

    public String resourceTwo() {
        System.out.println("resource two.");
        return "resource two";
    }
}
