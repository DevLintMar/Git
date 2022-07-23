package com.lintmar.springboot.controller;

import com.lintmar.springboot.entity.Account;
import com.lintmar.springboot.service.AccountService;
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
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping({"", "/", "/main"})
    public String main() {
        return "user";
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    @ResponseBody
    public List<Account> findAll() {
        return accountService.findAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Account save(String username, String password, String[] roles) {
        return accountService.save(username, password, roles);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public void delete(String username) {
        accountService.deleteByUsername(username);
    }
}
