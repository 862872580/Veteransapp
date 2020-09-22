package com.jeethink.project.army.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    public void setString(String key, Object value){
        set(key,value,null);
    }

    public void setString(String key, Object value, Long timeout){
        set(key,value,timeout);
    }

    public void set(String key, Object value, Long timeout){
        if (value == null){
            return;
        }
        if(value instanceof String){
            stringRedisTemplate.opsForValue().set(key, (String) value);
            if (timeout != null) {
                stringRedisTemplate.expire(key, timeout, TimeUnit.SECONDS);
            }
        }
    }

    public Object getString(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 获取redis中以某字符串为前缀的KEY列表代码
     */
    public Set<String> selectAll(String s) {
        Set<String> keys = redisTemplate.keys(s);
        return keys;
    }

    /**
     * 批量删除
     * @param set 模糊查询出的key的集合
     */
    private void deleteSet(Set<String> set) {
        redisTemplate.delete(set);
    }


}
