package com.myspring.service;

import com.myspring.config.MyComponent;
import com.myspring.config.MyScope;

@MyComponent
@MyScope("protest")
public class TestServiceTwo {
    public void test() {
        System.out.println("我是testtwo");
    }
}
