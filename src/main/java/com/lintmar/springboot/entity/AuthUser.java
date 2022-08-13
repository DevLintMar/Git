package com.lintmar.springboot.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author LintMar
 * @date 2022/7/16
 **/
@Data
@Deprecated
public class AuthUser implements Serializable {
    @Serial
    private static final long serialVersionUID = 6383114539726654668L;
    private String username;
    private String password;
    private String roles;
}
