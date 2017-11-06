package com.tikie.shiro.service.impl;

import com.tikie.shiro.entity.Authorization;
import com.tikie.shiro.mapper.AuthorizationMapper;
import com.tikie.shiro.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @targget     AuthorizationServiceImpl
 *
 * @author      tikie
 * @date        2016-10-09
 * @version     1.0.0
 */
@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    @Autowired
    AuthorizationMapper authorizationMapper;
    public Authorization getById(String id){
        return authorizationMapper.getById(id);
    }

    public List<Authorization> getByRoleIds(String[] roleIds){
        return authorizationMapper.getByRoleIds(roleIds);
    }
}
