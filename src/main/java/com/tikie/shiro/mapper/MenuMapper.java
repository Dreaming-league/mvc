package com.tikie.shiro.mapper;

import com.tikie.shiro.entity.Menu;
import com.tikie.test.mapper.MyBatisRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author TiKie
 * @desc 目的
 * @date 2017/10/17
 */
@MyBatisRepository
public interface MenuMapper {
    Menu getById(@Param("id") String id);
}
