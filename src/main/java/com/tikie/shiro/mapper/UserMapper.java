package com.tikie.shiro.mapper;

import com.tikie.shiro.entity.User;
import com.tikie.test.mapper.BaseMapper;
import com.tikie.test.mapper.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @targget     UserMapper
 *
 * @author      tikie
 * @date        2016-10-04
 * @version     1.0.0
 */
@MyBatisRepository
public interface UserMapper extends BaseMapper {

    Boolean add(User user);

    User getById(@Param("id") String id);

    Boolean deleteByIds(@Param("ids") String[] ids);

    Boolean update(User user);

    User getByAccount(@Param("account") String account);

    List<User> getAll(@Param("start") Integer start,@Param("limit") Integer limit);
}
