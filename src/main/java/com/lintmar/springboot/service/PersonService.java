package com.lintmar.springboot.service;

import com.lintmar.springboot.entity.Person;

import java.util.List;

/**
 * @author LintMar
 * @date 2022/7/23
 **/
public interface PersonService {
    List<Person> findByUsername(String username);

    List<Person> findByUsernameOrPassword(String username, String password);

    List<Person> findByUsernameContaining(String username);

    List<Person> findByUsernameStartingWith(String username);

    List<Person> findByUsernameEndingWith(String username);

    Person save(Person person);

    long count();

    boolean existsByUsername(String username);

    long countDistinctByUsername(String username);

    void deleteByUsername(String username);
}
