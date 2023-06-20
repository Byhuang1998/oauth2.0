package com.byhuang.springmvc.interceptor;

import com.byhuang.springmvc.pojo.dto.LoginResult;
import com.byhuang.springmvc.service.PermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @date 2023/6/18 22:34
 * @description TODO
 */
@Component
@Order(1)
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {
    private Set<String> whiteList = new HashSet<>(Arrays.asList("/login", "/logout"));

    @Autowired
    private PermissionService permissionService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        // to judge if the request URI is in the white list.
        if (whiteList.contains(requestURI)) {
            log.info("the interface [{}] need not authenticate", requestURI);
            return true;
        }
        // to judge if the user has logged in.
        Object o = request.getSession().getAttribute("user");
        if (Objects.isNull(o)) {
            log.info("please log in...");
            return false;
        }
        LoginResult loginResult = (LoginResult) o;
        // to get the permission the user has.
        List<String> permissions = permissionService.listPermission(loginResult.getRetMsg());
        if (!permissions.contains(requestURI)) {
            log.info("no permission for the resource...");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

}