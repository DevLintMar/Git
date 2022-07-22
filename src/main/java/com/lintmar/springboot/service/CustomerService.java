package com.lintmar.springboot.service;

import com.lintmar.springboot.entity.Customer;

import java.util.List;

/**
 * @author LintMar
 * @date 2022/7/16
 **/
public interface CustomerService {
    List<Customer> getAll();
}
