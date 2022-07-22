package com.lintmar.springboot.service;

import com.lintmar.springboot.entity.AuthUser;

import java.util.List;

/**
 * @author LintMar
 * @date 2022/7/16
 **/
public interface UserService {
    List<AuthUser> getAll();

    AuthUser addUser(String username, String password);

    AuthUser addUser(String username, String password, String... roles);

    int deleteUser(String username);

    boolean checkUsername(String username);

    boolean sendCode(String email);

    boolean checkCode(String email, String code);
}
