package com.lintmar.springboot.config;

import com.lintmar.springboot.mapper.cache.RedisMyBatisCache;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author LintMar
 * @date 2022/7/23
 **/
@Configuration
public class RedisMyBatisCacheConfiguration {
    @Resource
    private RedisTemplate<Object, Object> template;

    @PostConstruct
    public void init() {
        RedisMyBatisCache.setTemplate(template);
    }
}
