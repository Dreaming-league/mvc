package com.tikie.shiro.mapper;

import com.tikie.shiro.entity.Role;
import com.tikie.test.mapper.MyBatisRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 *              RoleMapper
 *
 * @author      tikie
 *              2016-10-09
 * @version     1.0.0
 */
@MyBatisRepository
public interface RoleMapper {

    Role getById(@Param("id") String id);

    List<Role> getByGroupIds(@Param("groupIds") String[] groupIds);
}
