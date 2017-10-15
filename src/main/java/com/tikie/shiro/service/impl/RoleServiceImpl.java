package com.tikie.shiro.service.impl;

import com.tikie.shiro.entity.Role;
import com.tikie.shiro.mapper.RoleMapper;
import com.tikie.shiro.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *              RoleMapper
 *
 * @author      tikie
 *              2016-10-09
 * @version     1.0.0
 *
 */
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleMapper roleMapper;

    public Role getById(String id){
        return roleMapper.getById(id);
    }
}
