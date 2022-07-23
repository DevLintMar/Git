package com.lintmar.springboot.service.impl;

import com.lintmar.springboot.entity.AuthUser;
import com.lintmar.springboot.mapper.UserMapper;
import com.lintmar.springboot.service.UserService;
import com.lintmar.springboot.utils.EncoderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author LintMar
 * @date 2022/7/16
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Resource
    private StringRedisTemplate template;

    @Resource
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public List<AuthUser> getAll() {
        return userMapper.getAll();
    }

    @Override
    public AuthUser addUser(String username, String password) {
        AuthUser authUser = new AuthUser();
        authUser.setUsername(username);
        authUser.setPassword(EncoderUtils.encode(password));
        authUser.setRoles("user");
        userMapper.addUser(authUser);
        return authUser;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public AuthUser addUser(String username, String password, String... roles) {
        AuthUser authUser = new AuthUser();
        StringBuilder rolesStr = new StringBuilder();
        for (String role : roles) {
            rolesStr.append(role);
            rolesStr.append(",");
        }
        if (rolesStr.length() != 0) {
            rolesStr.deleteCharAt(rolesStr.length() - 1);
            authUser.setRoles(rolesStr.toString());
        } else authUser.setRoles(null);
        authUser.setUsername(username);
        authUser.setPassword(EncoderUtils.encode(password));
        userMapper.addUser(authUser);
        return authUser;
    }

    @Override
    public int deleteUser(String username) {
        return userMapper.deleteUser(username);
    }

    @Override
    public boolean checkUsername(String username) {
        return userMapper.getUser(username) == null;
    }

    @Override
    public boolean sendCode(String email) {
        String key = "code:" + email;
        if (template.opsForValue().get(key) == null) {
            String code = String.valueOf(new Random().nextInt(900000) + 100000);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject("[LintMar]注册邮箱验证");
            message.setText("您的邮箱验证码为: " + code + "\n三分钟内有效，请及时完成注册!如非本人操作，请忽略");
            message.setFrom(from);
            message.setTo(email);
            template.opsForValue().set("code:" + email, code, 3, TimeUnit.MINUTES);
            mailSender.send(message);
            return true;
        }
        return false;
    }

    @Override
    public boolean checkCode(String email, String code) {
        String key = "code:" + email;
        if (code.equals(template.opsForValue().get(key))) {
            template.delete("code:" + email);
            return true;
        }
        return false;
    }
}
