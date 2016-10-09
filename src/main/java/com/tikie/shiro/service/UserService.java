package com.tikie.shiro.service;

import com.tikie.shiro.entity.User;

/**
 * @targget     UserService
 *
 * @author      tikie
 * @date        2016-10-04
 * @version     1.0.0
 */
public interface UserService {
    /**
     * @target  测试用ID查询友好信息
     * @param   id
     *
     * @return  HelloWorld
     */
    User getById(Integer id);
}
