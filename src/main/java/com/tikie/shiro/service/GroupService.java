package com.tikie.shiro.service;

import com.tikie.shiro.entity.Group;

import java.util.List;

/**
 * @author TiKie
 * @desc 目的
 * @date 2017/10/16
 */
public interface GroupService {
    Group getById(String id);

    List<Group> getByIds(String[] ids);
}
