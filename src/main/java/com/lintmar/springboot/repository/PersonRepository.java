package com.lintmar.springboot.repository;

import com.lintmar.springboot.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author LintMar
 * @date 2022/7/22
 **/
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findByUsername(String username);

    List<Person> findByUsernameOrPassword(String username, String password);

    List<Person> findByUsernameContaining(String username);

    List<Person> findByUsernameStartingWith(String username);

    List<Person> findByUsernameEndingWith(String username);

    int countDistinctByUsername(String username);

    boolean existsByUsername(String username);

    @Transactional
    void deleteByUsername(String username);
}
