package com.lintmar.springboot.listener;

import com.lintmar.springboot.listener.event.TestEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author LintMar
 * @date 2022/7/17
 **/
@Slf4j
@Component
public class TestListener implements ApplicationListener<TestEvent> {
    @Override
    public void onApplicationEvent(TestEvent event) {
        log.info("Test事件：" + event.getSource());
    }
}
