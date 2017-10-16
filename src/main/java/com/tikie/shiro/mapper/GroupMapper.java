package com.tikie.shiro.mapper;

import com.tikie.shiro.entity.Group;
import com.tikie.test.mapper.MyBatisRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author TiKie
 * @desc 目的
 * @date 2017/10/16
 */
@MyBatisRepository
public interface GroupMapper {
    Group getById(@Param("id") String id);
}
