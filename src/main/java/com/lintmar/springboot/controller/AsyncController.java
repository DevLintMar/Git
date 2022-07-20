package com.lintmar.springboot.controller;

import com.lintmar.springboot.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LintMar
 * @date 2022/7/17
 **/
@Controller
@RequestMapping("/async")
public class AsyncController {
    @Autowired
    AsyncService asyncService;

    @RequestMapping("/async")
    public String async() throws InterruptedException {
        asyncService.async();
        return "show";
    }

    @RequestMapping("/synchronize")
    public String synchronize() throws InterruptedException {
        asyncService.synchronize();
        return "show";
    }
}
