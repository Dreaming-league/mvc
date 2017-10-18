package com.tikie.shiro.mapper;

import com.tikie.shiro.entity.Authorization;
import com.tikie.test.mapper.MyBatisRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @targget     AuthorizationMapper
 *
 * @author      tikie
 * @date        2016-10-09
 * @version     1.0.0
 */
@MyBatisRepository
public interface AuthorizationMapper {

    Authorization getById(@Param("id") String id);

    List<Authorization> getByRoleIds(@Param("roleIds") String[] roleIds);
}
