package com.lintmar.springboot.controller;

import com.lintmar.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author LintMar
 * @date 2022/7/22
 **/
@Controller
public class SystemController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/checkUsername", method = RequestMethod.POST)
    @ResponseBody
    public void checkUsername(String username) {
        if (!userService.checkUsername(username)) throw new RuntimeException();
    }

    @RequestMapping(value = "/sendCode", method = RequestMethod.POST)
    @ResponseBody
    public void sendCode(String email) {
        if (!userService.sendCode(email)) throw new RuntimeException();
    }

    @RequestMapping(value = "/checkCode", method = RequestMethod.POST)
    @ResponseBody
    public void checkCode(String email, String code) {
        if (!userService.checkCode(email, code)) throw new RuntimeException();
    }

    @RequestMapping(value = "/doReg", method = RequestMethod.POST)
    public String doReg(String username, String password) {
        userService.addUser(username, password, "user");
        return "index";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
