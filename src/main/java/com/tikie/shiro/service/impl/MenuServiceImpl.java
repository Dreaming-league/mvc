package com.tikie.shiro.service.impl;

import com.tikie.shiro.entity.Menu;
import com.tikie.shiro.mapper.MenuMapper;
import com.tikie.shiro.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author TiKie
 * @desc 目的
 * @date 2017/10/17
 */
@Service
public class MenuServiceImpl implements MenuService{
    @Autowired
    MenuMapper menuMapper;

    public Menu getById(String id){
        return menuMapper.getById(id);
    }
}
