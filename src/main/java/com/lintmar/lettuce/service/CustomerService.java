package com.lintmar.lettuce.service;

import com.lintmar.lettuce.bean.Customer;

import java.util.List;

/**
 * @author LintMar
 * @date 2022/7/21
 **/
public interface CustomerService {
    List<Customer> getAll();
}
