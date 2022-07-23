package com.lintmar.springboot.service;

import com.lintmar.springboot.entity.Account;

import java.util.List;

/**
 * @author LintMar
 * @date 2022/7/16
 **/
public interface AccountService {
    List<Account> findAll();

    Account save(String username, String password);

    Account save(String username, String password, String... roles);

    void deleteByUsername(String username);

    boolean checkUsername(String username);

    boolean sendCode(String email);

    boolean checkCode(String email, String code);
}
