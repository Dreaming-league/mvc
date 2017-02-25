package com.tikie.common.dao;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.tikie.shiro.entity.User;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author zcs
 * @desc 目的
 * @date 2017/2/23
 */
public class RedisDao {
    private final JedisPool jedisPool;

    public RedisDao(String ip,int port){
        jedisPool = new JedisPool(ip,port);
    }

    private RuntimeSchema<User> schema = RuntimeSchema.createFrom(User.class);

    public User getUser(long id){
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "user:"+id;
                /**
                 * 并没有实现内部序列化操作
                 * get返回byte[]数组，通过反序列化转为Object
                 * 采用自定义序列化
                 * protostuff : pojo
                 */
                byte[] bytes = jedis.get(key.getBytes());
                if(bytes!=null){
                    //空对象
                    User user = schema.newMessage();
                    ProtostuffIOUtil.mergeFrom(bytes,user,schema);//user被反序列化
                    return user;
                }
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String putUser(User user){

        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "user:"+user.getId();
                byte[] bytes = ProtostuffIOUtil.toByteArray(user,schema,
                        LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
                //超时缓存
                int timeout = 60 * 60;//1小时
                String result = jedis.setex(key.getBytes(),timeout,bytes);
                return result;
            } finally {
                jedis.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
