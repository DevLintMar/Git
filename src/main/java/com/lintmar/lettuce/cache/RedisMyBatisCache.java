package com.lintmar.lettuce.cache;

import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.connection.RedisServerCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author LintMar
 * @date 2022/7/21
 **/
public class RedisMyBatisCache implements Cache {
    private final String id;
    private static RedisTemplate<Object, Object> template;

    public RedisMyBatisCache(String id) {
        this.id = id;
    }

    public static void setTemplate(RedisTemplate<Object, Object> template) {
        RedisMyBatisCache.template = template;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void putObject(Object o, Object o1) {
        template.opsForValue().set(o, o1, 60, TimeUnit.SECONDS);
    }

    @Override
    public Object getObject(Object o) {
        return template.opsForValue().get(o);
    }

    @Override
    public Object removeObject(Object o) {
        return template.delete(o);
    }

    @Override
    public void clear() {
        template.execute((RedisCallback<Object>) connection -> {
            connection.flushDb();
            return null;
        });
    }

    @Override
    public int getSize() {
        return template.execute(RedisServerCommands::dbSize).intValue();
    }
}
