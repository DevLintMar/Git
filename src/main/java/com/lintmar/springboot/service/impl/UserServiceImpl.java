package com.lintmar.springboot.service.impl;

import com.lintmar.springboot.bean.AuthUser;
import com.lintmar.springboot.mapper.UserMapper;
import com.lintmar.springboot.service.UserService;
import com.lintmar.springboot.utils.EncoderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author LintMar
 * @date 2022/7/16
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<AuthUser> getAll() {
        return userMapper.getAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public AuthUser addUser(String username, String password, String[] roles) {
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
}
