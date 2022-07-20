package com.lintmar.springboot.service.impl;

import com.lintmar.springboot.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author LintMar
 * @date 2022/7/17
 **/
@Slf4j
@Service
public class AsyncServiceImpl implements AsyncService {
    @Override
    public void async() throws InterruptedException {
        Thread.sleep(3000);
        log.info("异步方法执行");
    }

    @Override
    public void synchronize() throws InterruptedException {
        Thread.sleep(3000);
        log.info("同步方法执行");
    }
}
