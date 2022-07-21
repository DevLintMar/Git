package com.lintmar.lettuce.controller;

import com.lintmar.lettuce.bean.Customer;
import com.lintmar.lettuce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author LintMar
 * @date 2022/7/21
 **/
@Controller
@RequestMapping("/cache")
public class CustomerController {
    @Autowired
    CustomerService service;

    @RequestMapping("/customer")
    @ResponseBody
    public List<Customer> customer() {
        return service.getAll();
    }
}
