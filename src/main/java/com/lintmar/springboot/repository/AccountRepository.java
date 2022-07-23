package com.lintmar.springboot.repository;

import com.lintmar.springboot.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface AccountRepository extends JpaRepository<Account, String> {
    Account findByUsername(String username);

    @Transactional
    void deleteByUsername(String username);
}