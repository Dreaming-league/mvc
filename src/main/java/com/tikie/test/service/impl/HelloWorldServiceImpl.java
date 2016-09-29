package com.tikie.test.service.impl;

import com.tikie.test.entity.HelloWorld;
import com.tikie.test.mapper.HelloWorldMapper;
import com.tikie.test.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @targget     测试web响应测试Controller类
 *
 * @author      tikie
 * @date        2016-09-28
 * @version     1.0.0
 */
@Service
public class HelloWorldServiceImpl implements HelloWorldService{

    @Autowired
    private HelloWorldMapper helloWorldMapper;

    /**
     * @target  测试用ID查询友好信息
     * @param   id
     *
     * @return  HelloWorld
     */
    public HelloWorld getById(Integer id){
        return helloWorldMapper.getById(id);
    }
}
