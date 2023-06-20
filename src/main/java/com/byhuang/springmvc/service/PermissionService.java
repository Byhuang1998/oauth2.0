package com.byhuang.springmvc.service;

import com.byhuang.springmvc.dao.PermissionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huangbingyi
 * @version 1.0
 * @date 2023/6/18 19:50
 * @description 权限服务
 */
@Service
public class PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    public List<String> listPermission(String uid) {
        return permissionDao.listPermission(uid);
    }
}
