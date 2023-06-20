package com.byhuang.springmvc.config;

import com.byhuang.springmvc.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author huangbingyi
 * @version 1.0
 * @date 2023/6/19 23:40
 * @description 拦截器注册配置类
 */
@Component
public class InterceptorAppConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // modified by by.
        //In order not to affect subsequent tests, unregister the interceptor first
//        registry.addInterceptor(authInterceptor);
    }
}
