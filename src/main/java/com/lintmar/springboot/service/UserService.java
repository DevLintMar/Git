package com.lintmar.springboot.service;

import com.lintmar.springboot.bean.AuthUser;

import java.util.List;

/**
 * @author LintMar
 * @date 2022/7/16
 **/
public interface UserService {
    List<AuthUser> getAll();

    AuthUser addUser(String username, String password, String[] roles);

    int deleteUser(String username);
}
