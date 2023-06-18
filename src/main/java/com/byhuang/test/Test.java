package com.byhuang.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @date 2023/6/18 14:04
 * @description TODO
 */
@RestController
public class Test {

    @RequestMapping("/test")
    public String test() {
        return "Hello World!";
    }
}
