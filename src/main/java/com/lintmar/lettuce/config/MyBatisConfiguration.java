package com.lintmar.lettuce.config;

import com.lintmar.lettuce.cache.RedisMyBatisCache;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author LintMar
 * @date 2022/7/21
 **/
@Configuration
public class MyBatisConfiguration {
    @Resource
    RedisTemplate<Object, Object> template;

    @PostConstruct
    public void init() {
        RedisMyBatisCache.setTemplate(template);
    }
}
