package com.lintmar.lettuce.service.impl;

import com.lintmar.lettuce.service.RedisService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author LintMar
 * @date 2022/7/21
 **/
@Service
public class RedisServiceImpl implements RedisService {
    @Resource
    StringRedisTemplate template;

    @PostConstruct
    public void init() {
        template.setEnableTransactionSupport(true);
    }

    @Override
    @Transactional
    public List<String> getList() {
        template.multi();
        template.opsForList().rightPushAll("la", "1", "2", "3");
        template.opsForList().rightPush("la", "2", "2.5");
        template.opsForList().leftPush("la", "2", "1.5");
        template.exec();
        List<String> list = template.opsForList().range("la", 0, -1);
        template.delete("la");
        return list;
    }

    @Override
    @Transactional
    public Set<String> getSet() {
        template.multi();
        template.opsForSet().add("sa", "a", "b", "c", "d");
        template.opsForSet().add("sb", "b", "c", "d", "e");
        template.opsForSet().add("sc", "c", "d", "e", "g");
        template.exec();
        Set<String> set = template.opsForSet().intersect(Arrays.asList("sa", "sb", "sc"));
        template.delete("sa");
        template.delete("sb");
        template.delete("sc");
        return set;
    }
}
