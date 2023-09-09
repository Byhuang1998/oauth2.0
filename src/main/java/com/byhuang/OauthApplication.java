package com.byhuang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author huangbingyi
 * @version 1.0
 * @date 2023/6/18 13:53
 * @description TODO
 */
@SpringBootApplication
public class OauthApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext application = SpringApplication.run(OauthApplication.class, args);
        System.out.println();
    }
}
