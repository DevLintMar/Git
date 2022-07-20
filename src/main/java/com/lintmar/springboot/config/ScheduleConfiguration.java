package com.lintmar.springboot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

/**
 * @author LintMar
 * @date 2022/7/17
 **/
@Slf4j
@Configuration
public class ScheduleConfiguration {
    @Scheduled(fixedRate = 60000)
    public void timerTask() {
        log.info("当前时间：" + new Date());
    }

    @Scheduled(cron = "0 */3 * * * ?")
    public void cronTask() {
        log.info("同步订单（3min each）");
    }
}
