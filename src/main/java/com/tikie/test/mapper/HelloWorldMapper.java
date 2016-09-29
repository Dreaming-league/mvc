package com.tikie.test.mapper;

import com.tikie.test.entity.HelloWorld;
import org.springframework.data.repository.query.Param;

/**
 * @targget     测试web响应测试Controller类
 *
 * @author      tikie
 * @date        2016-09-28
 * @version     1.0.0
 */
@MyBatisRepository
public interface HelloWorldMapper extends BaseMapper{

    /**
     * @target  测试用ID查询友好信息
     * @param   id
     *
     * @return  HelloWorld
     */
    HelloWorld getById(@Param("id") Integer id);
}
