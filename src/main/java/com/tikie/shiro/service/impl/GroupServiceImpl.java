package com.tikie.shiro.service.impl;

import com.tikie.shiro.entity.Group;
import com.tikie.shiro.mapper.GroupMapper;
import com.tikie.shiro.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author TiKie
 * @desc 目的
 * @date 2017/10/16
 */
@Service
public class GroupServiceImpl implements GroupService{
    @Autowired
    GroupMapper groupMapper;

    public Group getById(String id){
        return groupMapper.getById(id);
    }

    public List<Group> getByIds(String[] ids){
        return groupMapper.getByIds(ids);
    }
}
