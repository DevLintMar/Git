package com.lintmar.springboot.service.impl;

import com.lintmar.springboot.bean.Customer;
import com.lintmar.springboot.mapper.CustomerMapper;
import com.lintmar.springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LintMar
 * @date 2022/7/16
 **/
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> getAll() {
        return customerMapper.getAll();
    }
}
