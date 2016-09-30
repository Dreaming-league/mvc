package com.tikie.test.service;

import com.tikie.test.entity.HelloWorld;

import java.util.List;

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
     *
     * @param   id
     * @return  HelloWorld
     */
    HelloWorld getById(Integer id);

    /**
     * @target  新增一条记录
     *
     * @param   helloWorld
     * @return  新插入行的主键
     */
    Integer insert(HelloWorld helloWorld);

    /**
     * @target  按照ID删除友好信息
     *
     * @param   id
     * @return  删除的行数
     */
    Integer deleteById(Integer id);

    /**
     * @target  更新
     *
     * @param   helloWorld
     * @return  更新的行数
     */
    Integer update(HelloWorld helloWorld);

    /**
     * @target  按照message模糊查询
     *
     * @param   message
     * @return  List<HelloWorld>
     */
    List<HelloWorld> getSimilarByMessage(String message);

    /**
     * @target  获得全部友好信息
     *
     * @return  List<HelloWorld>
     */
    List<HelloWorld> getAll();


    //分页接口
}
