package com.byhuang.session.controller;

import com.byhuang.session.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @date 2023/6/18 22:27
 * @description 资源控制器
 */
@RestController("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @PostMapping("/r1")
    public String resourceOne() {
        return resourceService.resourceOne();
    }

    @PostMapping("/r2")
    public String resourceTwo() {
        return resourceService.resourceTwo();
    }
}
