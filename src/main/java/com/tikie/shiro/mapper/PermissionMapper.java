package com.tikie.shiro.mapper;

import com.tikie.shiro.entity.Permission;
import com.tikie.test.mapper.MyBatisRepository;
import org.springframework.data.repository.query.Param;

/**
 * @targget     PermissionMapper
 *
 * @author      tikie
 * @date        2016-10-09
 * @version     1.0.0
 */
@MyBatisRepository
public interface PermissionMapper {

    Permission getById(@Param("id") String id);
}
