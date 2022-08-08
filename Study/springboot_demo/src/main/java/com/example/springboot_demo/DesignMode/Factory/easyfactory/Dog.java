package com.example.springboot_demo.DesignMode.Factory.easyfactory;

public class Dog implements Animal {

    @Override
    public void say() {
        System.out.println("我是小狗，汪汪汪！！！！");
    }

    @Override
    public void eat() {
        System.out.println("我是小狗，我爱吃骨头");
    }
}
