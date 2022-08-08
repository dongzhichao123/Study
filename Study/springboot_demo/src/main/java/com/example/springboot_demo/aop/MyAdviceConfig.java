package com.example.springboot_demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
@Aspect
public class MyAdviceConfig {
    @Before(value = "within(com.example.springboot_demo.MybatisXml.*)")
    public void before(JoinPoint joinPoint) {
        System.out.println("before开始执行查询.......");
        System.out.println("正在执行的目标类是: " + joinPoint.getTarget());
        System.out.println("正在执行的目标方法是: " + joinPoint.getSignature().getName());
    }

    @After(value = "within(com.example.springboot_demo.MybatisXml.*)")
    public void after(JoinPoint joinPoint) {
        System.out.println("after开始执行查询.......");
        System.out.println("正在执行的目标类是: " + joinPoint.getTarget());
        System.out.println("正在执行的目标方法是: " + joinPoint.getSignature().getName());
    }

}
