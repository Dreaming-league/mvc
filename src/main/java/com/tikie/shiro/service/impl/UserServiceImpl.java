package com.tikie.shiro.service.impl;

import com.tikie.common.util.CacheUtils;
import com.tikie.shiro.entity.User;
import com.tikie.shiro.mapper.UserMapper;
import com.tikie.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *              UserServiceImpl(缓存管理需要启动项目这才能用)
 *
 * @author      tikie
 * @since       2016-10-04
 * @version     1.0.0
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    public static final String USER_CACHE = "userCache";
    public static final String USER_CACHE_ID_ = "userId_";
    public static final String USER_CACHE_USER_ = "user_";

    /**
     *
     * @param   id
     *
     * @return  User
     */
    public User getById(Integer id) {
        User user = (User) CacheUtils.get(USER_CACHE, USER_CACHE_ID_ + id);
        if (user ==  null){
            user = userMapper.getById(id);
            if (user == null){
                return null;
            }
            CacheUtils.put(USER_CACHE, USER_CACHE_ID_ + user.getId(), user);
        }
        return user;
    }

    /**
     *
     * @param   account
     * @return  User
     */
    public User getByAccount(String account){
        User user = (User) CacheUtils.get(USER_CACHE, USER_CACHE_ID_ + account);
        if (user ==  null){
            user = userMapper.getByAccount(account);
            if (user == null){
                return null;
            }
            CacheUtils.put(USER_CACHE, USER_CACHE_ID_ + user.getAccount(), user);
        }
        return user;
    }

    /**
     * 获取没有被逻辑删除的用户信息
     * @return  List<User>
     */
    public List<User> getAll(){
//        List<User> list = (List<User>) CacheUtils.get(USER_CACHE,USER_CACHE_USER_ + "list");
//        if(list ==null ||list.size() <=0){
//            list = userMapper.getAll();
//            if(list ==null ||list.size() <=0){
//                return null;
//            }
//            CacheUtils.put(USER_CACHE,USER_CACHE_USER_ + "list");
//        }
//        return list;
        return userMapper.getAll();
    }
}
