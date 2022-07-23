package com.lintmar.springboot.controller;

import com.lintmar.springboot.entity.Person;
import com.lintmar.springboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author LintMar
 * @date 2022/7/23
 **/
@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping("/find")
    @ResponseBody
    public List<Person> find(String username, String password, String method) {
        if (username == null || username.isEmpty()) throw new RuntimeException("Args Error");
        if (password != null && !password.isEmpty()) return personService.findByUsernameOrPassword(username, password);
        if (method == null || method.isEmpty()) return personService.findByUsername(username);
        List<Person> result;
        switch (method) {
            case "containing" -> result = personService.findByUsernameContaining(username);
            case "startingWith" -> result = personService.findByUsernameStartingWith(username);
            case "endingWith" -> result = personService.findByUsernameEndingWith(username);
            default -> throw new RuntimeException("Method Error");
        }
        return result;
    }

    @RequestMapping("/save")
    @ResponseBody
    public Person save(String username, String password) {
        Person person = new Person();
        person.setUsername(username);
        person.setPassword(password);
        return personService.save(person);
    }

    @RequestMapping("/count")
    @ResponseBody
    public long count(String username) {
        if (username == null || username.isEmpty()) return personService.count();
        return personService.countDistinctByUsername(username);
    }

    @RequestMapping("/exists")
    @ResponseBody
    public boolean exists(String username) {
        if (username == null) throw new RuntimeException("Id Error");
        return personService.existsByUsername(username);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public void delete(String username) {
        if (username == null) throw new RuntimeException("Args Error");
        personService.deleteByUsername(username);
    }
}
