package com.lintmar.springboot.controller;

import com.lintmar.springboot.bean.AuthUser;
import com.lintmar.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author LintMar
 * @date 2022/7/16
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping({"", "/", "/main"})
    public String main() {
        return "user";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.POST)
    @ResponseBody
    public List<AuthUser> getAll() {
        return userService.getAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public AuthUser add(String username, String password, String[] roles) {
        return userService.addUser(username, password, roles);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(String username) {
        if (userService.deleteUser(username) == 1) {
            return username;
        }
        throw new RuntimeException();
    }
}
