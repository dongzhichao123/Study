package com.myspring.service;

import com.myspring.config.MyAutowired;
import com.myspring.config.MyComponent;
import com.myspring.config.MyInitializingBean;
import com.myspring.config.MyScope;
import org.springframework.beans.factory.config.BeanPostProcessor;

@MyComponent
@MyScope
public class TestService implements MyInitializingBean,Service  {

    @MyAutowired
    private TestServiceTwo TestServiceTwo;

    public void test() {
        System.out.println("我是TestService");
        TestServiceTwo.test();
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("初始化");
    }
}
