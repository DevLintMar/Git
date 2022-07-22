package com.lintmar.springboot.controller;

import com.lintmar.springboot.entity.Customer;
import com.lintmar.springboot.bean.Student;
import com.lintmar.springboot.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author LintMar
 * @date 2022/7/15
 **/
@Slf4j
@Controller
@RequestMapping("/main")
public class MainController {
    @Value("${student.id}")
    private int id;
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/index")
    @ResponseBody
    public String index() {
        return "<h1>Welcome to index controller</h1>";
    }

    @RequestMapping("/student")
    @ResponseBody
    public Student student() {
        Student student = new Student();
        student.setId(id);
        student.setName("张三");
        student.setSex("男");
        return student;
    }

    @RequestMapping("/customer")
    @ResponseBody
    public List<Customer> customer() {
        return customerService.getAll();
    }

    @RequestMapping("/thymeleaf")
    public String thymeleaf(HttpServletRequest request) {
        MDC.put("sessionId", request.getSession().getId());
        log.info("Thymeleaf页面被访问");
        request.setAttribute("customers", customerService.getAll());
        return "thymeleaf";
    }
}
