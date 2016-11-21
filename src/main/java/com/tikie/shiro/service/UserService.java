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
    Boolean add(User user);

    User getById(Integer id);

    Boolean deleteByIds(Integer[] ids);

    Boolean update(User user);

    User getByAccount(String account);

    /**
     * 查找所有isDelete为0的用户，分页需要在ResponseJson中配置，默认0,10
     *
     * @return  List<User>
     */
    List<User> getAll();
}
