package com.lintmar.springboot.controller;

import com.lintmar.springboot.bean.User;
import com.lintmar.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author LintMar
 * @date 2022/7/16
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/add")
    @ResponseBody
    public User add(String username, String password) {
        return userService.addUser(username, password);
    }
}
