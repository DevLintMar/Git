package com.lintmar.lettuce.service.impl;

import com.lintmar.lettuce.bean.Student;
import com.lintmar.lettuce.service.ObjectRedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author LintMar
 * @date 2022/7/21
 **/
@Service
public class ObjectRedisServiceImpl implements ObjectRedisService {
    @Resource
    RedisTemplate<Object, Object> template;

    @PostConstruct
    public void init() {
        template.setEnableTransactionSupport(true);
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
    }

    @Override
    @Transactional
    public List<Object> getStudentList() {
        template.multi();
        Student s1 = new Student();
        s1.setId(1);
        s1.setName("张三");
        s1.setAge(24);
        Student s2 = new Student();
        s2.setId(2);
        s2.setName("李四");
        s2.setAge(22);
        Student s3 = new Student();
        s3.setId(3);
        s3.setName("王五");
        s3.setAge(31);
        Student s4 = new Student();
        s4.setId(4);
        s4.setName("赵六");
        s4.setAge(20);
        Student s5 = new Student();
        s5.setId(5);
        s5.setName("钱七");
        s5.setAge(26);
        template.opsForList().rightPushAll("students", s1, s2, s3);
        template.opsForList().leftPush("students", s2, s4);
        template.opsForList().rightPush("students", s2, s5);
        template.exec();
        List<Object> studentList = template.opsForList().range("students", 0, -1);
        template.delete("students");
        return studentList;
    }
}
