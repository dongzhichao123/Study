package com.example.springboot_demo.DesignMode.Factory.easyfactory;

public class Cat  implements Animal {

    @Override
    public void say() {
        System.out.println("我是小猫，喵喵喵！！！！");
    }

    @Override
    public void eat() {
        System.out.println("我是小猫，我爱吃鱼！！！！！");
    }
}
