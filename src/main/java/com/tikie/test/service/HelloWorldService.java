package com.tikie.test.service;

import com.tikie.test.entity.HelloWorld;

/**
 * @targget     测试web响应测试Controller类
 *
 * @author      tikie
 * @date        2016-09-28
 * @version     1.0.0
 */
public interface HelloWorldService {
    /**
     * @target  测试用ID查询友好信息
     * @param   id
     *
     * @return  HelloWorld
     */
    HelloWorld getById(Integer id);
}
