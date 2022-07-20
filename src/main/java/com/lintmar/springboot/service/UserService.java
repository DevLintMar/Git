package com.lintmar.springboot.service;

import com.lintmar.springboot.bean.User;

/**
 * @author LintMar
 * @date 2022/7/16
 **/
public interface UserService {
    User addUser(String username, String password);
}
