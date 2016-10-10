package com.tikie.shiro.mapper;

import com.tikie.shiro.entity.User;
import com.tikie.test.mapper.BaseMapper;
import com.tikie.test.mapper.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

/**
 * @targget     UserMapper
 *
 * @author      tikie
 * @date        2016-10-04
 * @version     1.0.0
 */
@MyBatisRepository
public interface UserMapper extends BaseMapper {

    User getById(@Param("id") Integer id);

    User getByAccount(@Param("account") String account);
}
