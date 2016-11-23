package com.tikie.generator.mapper;

import com.tikie.generator.entity.Test;
import com.tikie.generator.entity.TestExample;
import java.util.List;

import com.tikie.test.mapper.MyBatisRepository;
import org.apache.ibatis.annotations.Param;
@MyBatisRepository
public interface TestMapper {
    int countByExample(TestExample example);

    int deleteByExample(TestExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Test record);

    int insertSelective(Test record);

    List<Test> selectByExample(TestExample example);

    Test selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Test record, @Param("example") TestExample example);

    int updateByExample(@Param("record") Test record, @Param("example") TestExample example);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);
}