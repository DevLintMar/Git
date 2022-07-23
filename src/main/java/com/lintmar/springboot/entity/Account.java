package com.lintmar.springboot.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author LintMar
 * @date 2022/7/23
 **/
@Data
@Entity
@Table(name = "account")
public class Account {
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "roles")
    private String roles;
}
