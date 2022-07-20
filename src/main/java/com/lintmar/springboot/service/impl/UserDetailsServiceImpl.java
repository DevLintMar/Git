package com.lintmar.springboot.service.impl;

import com.lintmar.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author LintMar
 * @date 2022/7/16
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String password = userMapper.getPasswordByUsername(username);
        if (password == null) throw new UsernameNotFoundException("用户名或密码错误");
        return User.withUsername(username).password(password).roles("user").build();
    }
}
