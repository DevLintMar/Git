package com.lintmar.springboot.bean;

import lombok.Data;

/**
 * @author LintMar
 * @date 2022/7/16
 **/
@Data
public class AuthUser {
    private String username;
    private String password;
    private String roles;
}