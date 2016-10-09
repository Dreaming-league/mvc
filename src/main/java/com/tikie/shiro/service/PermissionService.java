package com.tikie.shiro.service;

import com.tikie.shiro.entity.Permission;

/**
 * @targget     PermissionService
 *
 * @author      tikie
 * @date        2016-10-09
 * @version     1.0.0
 */
public interface PermissionService {


    Permission getById(Integer id);
}
