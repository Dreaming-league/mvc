package com.tikie.generator.service.impl;

import com.tikie.generator.entity.TestExample;
import com.tikie.generator.mapper.TestMapper;
import com.tikie.generator.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zcs
 * @desc 目的
 * @date 2016/11/23
 */
@Service
public class TestServiceImpl implements TestService{

    @Autowired
    TestMapper testMapper;
    public int deleteByExample(TestExample example){


        return testMapper.deleteByExample(example);
    }
}
