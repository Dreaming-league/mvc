package com.tikie.test.service.impl;

import com.tikie.test.entity.HelloWorld;
import com.tikie.test.mapper.HelloWorldMapper;
import com.tikie.test.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @targget     HelloWorldServiceImpl
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

    /**
     * @target  新增一条记录
     *
     * @param   helloWorld
     * @return  新插入行的主键
     */
    public Integer insert(HelloWorld helloWorld){
        return helloWorldMapper.insert(helloWorld);
    }

    /**
     * @target  按照ID删除友好信息
     *
     * @param   id
     * @return  删除的行数
     */
    public Integer deleteById(Integer id){
        return helloWorldMapper.deleteById(id);
    }

    /**
     * @target  更新
     *
     * @param   helloWorld
     * @return  更新的行数
     */
    public Integer update(HelloWorld helloWorld){
        return helloWorldMapper.update(helloWorld);
    }

    /**
     * @target  按照message模糊查询
     *
     * @param   message
     * @return  List<HelloWorld>
     */
    public List<HelloWorld> getSimilarByMessage(String message){
        return helloWorldMapper.getSimilarByMessage(message);
    }

    /**
     * @target  获得全部友好信息
     *
     * @return  List<HelloWorld>
     */
    public List<HelloWorld> getAll(){
        return helloWorldMapper.getAll();
    }
}
