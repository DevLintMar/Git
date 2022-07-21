package com.lintmar.redistemplate.controller;

import com.lintmar.redistemplate.service.ObjectRedisService;
import com.lintmar.redistemplate.service.RedisService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author LintMar
 * @date 2022/7/21
 **/
@Controller
@RequestMapping("/redis")
public class RedisController {
    @Resource
    RedisService service;

    @Resource
    ObjectRedisService objectService;

    @RequestMapping("/show")
    public String show(Model model) {
        model.addAttribute("list", service.getList());
        model.addAttribute("set", service.getSet());
        return "show";
    }

    @RequestMapping("/object")
    public String object(Model model) {
        model.addAttribute("list", objectService.getStudentList());
        return "object";
    }
}
