package com.lintmar.springboot.service.impl;

import com.lintmar.springboot.entity.Person;
import com.lintmar.springboot.repository.PersonRepository;
import com.lintmar.springboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LintMar
 * @date 2022/7/23
 **/
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> findByUsername(String username) {
        return personRepository.findByUsername(username);
    }

    @Override
    public List<Person> findByUsernameOrPassword(String username, String password) {
        return personRepository.findByUsernameOrPassword(username, password);
    }

    @Override
    public List<Person> findByUsernameContaining(String username) {
        return personRepository.findByUsernameContaining(username);
    }

    @Override
    public List<Person> findByUsernameStartingWith(String username) {
        return personRepository.findByUsernameStartingWith(username);
    }

    @Override
    public List<Person> findByUsernameEndingWith(String username) {
        return personRepository.findByUsernameEndingWith(username);
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public long count() {
        return personRepository.count();
    }

    @Override
    public boolean existsByUsername(String username) {
        return personRepository.existsByUsername(username);
    }

    @Override
    public long countDistinctByUsername(String username) {
        return personRepository.countDistinctByUsername(username);
    }

    @Override
    public void deleteByUsername(String username) {
        personRepository.deleteByUsername(username);
    }
}
