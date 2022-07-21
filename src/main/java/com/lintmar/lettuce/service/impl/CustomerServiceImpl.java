package com.lintmar.lettuce.service.impl;

import com.lintmar.lettuce.bean.Customer;
import com.lintmar.lettuce.mapper.CustomerMapper;
import com.lintmar.lettuce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LintMar
 * @date 2022/7/21
 **/
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerMapper mapper;

    @Override
    public List<Customer> getAll() {
        return mapper.getAll();
    }
}
