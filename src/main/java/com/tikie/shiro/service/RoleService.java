package com.tikie.shiro.service;

import com.tikie.shiro.entity.Role;

import java.util.List;

/**
 *              RoleMapper
 *
 * @author      tikie
 *              2016-10-09
 * @version     1.0.0
 */
public interface RoleService {

    Role getById(String id);

    List<Role> getByGroupIds(String[] groupIds);
}
