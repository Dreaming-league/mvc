package com.tikie.shiro.service.impl;

import com.tikie.shiro.entity.User;
import com.tikie.shiro.mapper.UserMapper;
import com.tikie.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @targget     UserServiceImpl
 *
 * @author      tikie
 * @date        2016-10-04
 * @version     1.0.0
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    public User getById(Integer id) {
        return userMapper.getById(id);
    }

    public User getByAccount(String account){
        return userMapper.getByAccount(account);
    }
}
