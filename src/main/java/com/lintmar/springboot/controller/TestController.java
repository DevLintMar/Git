package com.lintmar.springboot.controller;

import com.lintmar.springboot.listener.event.TestEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LintMar
 * @date 2022/7/17
 **/
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private ApplicationContext ac;

    @RequestMapping("/show")
    public String test() {
        ac.publishEvent(new TestEvent("有人访问了show页面"));
        return "show";
    }
}
