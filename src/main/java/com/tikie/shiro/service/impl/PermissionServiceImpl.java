package com.tikie.shiro.service.impl;

import com.tikie.shiro.entity.Permission;
import com.tikie.shiro.mapper.PermissionMapper;
import com.tikie.shiro.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @targget     PermissionServiceImpl
 *
 * @author      tikie
 * @date        2016-10-09
 * @version     1.0.0
 */
@Service
public class PermissionServiceImpl implements PermissionService{

    @Autowired
    PermissionMapper permissionMapper;
    public Permission getById(Integer id){
        return permissionMapper.getById(id);
    }
}
