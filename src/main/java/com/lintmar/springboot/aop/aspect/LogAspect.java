package com.lintmar.springboot.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author LintMar
 * @date 2022/7/17
 **/
@Slf4j
@Aspect
@Component
public class LogAspect {
    @Before("execution(* com.lintmar.springboot.controller.*.*(..))")
    public void before(JoinPoint jp) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        StringBuffer url = request.getRequestURL();
        url.append("?");
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            url.append(name);
            url.append("=");
            url.append(request.getParameter(name));
            url.append("&");
        }
        url.deleteCharAt(url.length() - 1);
        log.info(request.getSession().getId() + "访问了" + url);
        log.info(jp.getSignature() + "方法开始执行");
    }
}
