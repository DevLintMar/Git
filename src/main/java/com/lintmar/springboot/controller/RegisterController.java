package com.lintmar.springboot.controller;

import com.lintmar.springboot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author LintMar
 * @date 2022/7/23
 **/
@Controller
@RequestMapping("/regCheck")
public class RegisterController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/checkUsername")
    @ResponseBody
    public void checkUsername(String username) {
        if (!accountService.checkUsername(username)) throw new RuntimeException();
    }

    @PostMapping("/sendCode")
    @ResponseBody
    public void sendCode(String email) {
        if (!accountService.sendCode(email)) throw new RuntimeException();
    }

    @PostMapping("/checkCode")
    @ResponseBody
    public void checkCode(String email, String code) {
        if (!accountService.checkCode(email, code)) throw new RuntimeException();
    }

    @PostMapping("/doReg")
    public String doReg(String username, String password) {
        accountService.save(username, password);
        return "index";
    }
}
