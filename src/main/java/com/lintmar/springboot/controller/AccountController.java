package com.lintmar.springboot.controller;

import com.lintmar.springboot.entity.Account;
import com.lintmar.springboot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author LintMar
 * @date 2022/7/16
 **/
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping({"", "/", "/main"})
    public String main() {
        return "user";
    }

    @PostMapping("/findAll")
    @ResponseBody
    public List<Account> findAll() {
        return accountService.findAll();
    }

    @PostMapping("/save")
    @ResponseBody
    public Account save(String username, String password, String[] roles) {
        return accountService.save(username, password, roles);
    }

    @PostMapping("/delete")
    @ResponseBody
    public void delete(String username) {
        accountService.deleteByUsername(username);
    }
}
