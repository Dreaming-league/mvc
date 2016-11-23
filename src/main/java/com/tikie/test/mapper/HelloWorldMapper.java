package com.tikie.test.mapper;

import com.tikie.test.entity.HelloWorld;
import org.springframework.data.repository.query.Param;

import java.util.List;

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
    HelloWorld getById(@Param("id") Long id);

    Boolean insert(@Param("helloWorld")HelloWorld helloWorld);

    /**
     * @target  按照ID删除友好信息
     *
     * @param   id
     * @return  删除的行数
     */
    Integer deleteById(@Param("id") Long id);

    Boolean update(@Param("helloWorld") HelloWorld helloWorld);

    /**
     * @target  按照message模糊查询
     *
     * @param   message
     * @return  List<HelloWorld>
     */
    List<HelloWorld> getSimilarByMessage(@Param("message") String message);

    /**
     * @target  获得全部友好信息
     *
     * @return  List<HelloWorld>
     */
    List<HelloWorld> getAll();
}
