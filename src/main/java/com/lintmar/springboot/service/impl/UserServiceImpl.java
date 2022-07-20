package com.lintmar.springboot.service.impl;

import com.lintmar.springboot.bean.User;
import com.lintmar.springboot.mapper.UserMapper;
import com.lintmar.springboot.service.UserService;
import com.lintmar.springboot.utils.EncoderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author LintMar
 * @date 2022/7/16
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User addUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(EncoderUtils.encode(password));
        userMapper.addUser(user);
        return user;
    }
}
