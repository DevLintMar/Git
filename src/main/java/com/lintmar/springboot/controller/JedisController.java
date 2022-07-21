package com.lintmar.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.Jedis;

/**
 * @author LintMar
 * @date 2022/7/21
 **/
@Controller
@RequestMapping("/jedis")
public class JedisController {


    @RequestMapping("/show")
    public String show(Model model) {
        try (Jedis jedis = new Jedis("localhost", 6379)) {
            jedis.sadd("a", "1", "2", "3", "4");
            jedis.sadd("b", "2", "3", "4", "5");
            jedis.sadd("c", "3", "4", "5", "6");
            model.addAttribute("set", jedis.sinter("a", "b", "c"));
        }
        return "show";
    }
}
