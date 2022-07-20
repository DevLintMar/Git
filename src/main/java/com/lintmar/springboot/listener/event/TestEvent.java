package com.lintmar.springboot.listener.event;

import org.springframework.context.ApplicationEvent;

import java.io.Serial;

/**
 * @author LintMar
 * @date 2022/7/17
 **/
public class TestEvent extends ApplicationEvent {
    @Serial
    private static final long serialVersionUID = -906727859674365758L;

    public TestEvent(Object source) {
        super(source);
    }
}
