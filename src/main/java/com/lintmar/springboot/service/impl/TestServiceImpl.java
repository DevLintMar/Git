package com.lintmar.springboot.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Service;

/**
 * @author LintMar
 * @date 2022/7/17
 **/
@Slf4j
@Service
public class TestServiceImpl implements BeanNameAware {
    @Override
    public void setBeanName(String s) {
        log.info("BeanName：" + s);
    }
}
