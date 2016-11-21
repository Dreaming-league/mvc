package com.tikie.shiro.service;

import com.tikie.shiro.entity.User;

import java.util.List;

/**
 * @targget     UserService
 *
 * @author      tikie
 * @date        2016-10-04
 * @version     1.0.0
 */
public interface UserService {
    /**
     * @target  用ID查询用户信息
     * @param   id
     *
     * @return  User
     */
    User getById(Integer id);

    User getByAccount(String account);

    List<User> getAll();
}
