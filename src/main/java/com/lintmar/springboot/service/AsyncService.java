package com.lintmar.springboot.service;

import org.springframework.scheduling.annotation.Async;

/**
 * @author LintMar
 * @date 2022/7/17
 **/
public interface AsyncService {
    @Async
    void async() throws InterruptedException;

    void synchronize() throws InterruptedException;
}
