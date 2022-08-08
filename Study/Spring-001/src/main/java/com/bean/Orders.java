package com.bean;

/**
 * @author dong
 * @title: Orders
 * @projectName Spring-001
 * @description: TODO
 * @date 2022/2/4 18:19
 **/
public class Orders {
    //无参数的构造
    public Orders(){
        System.out.println("第一步，无参构造方法");
    }
    private String name;

    public void setName(String name) {
        this.name = name;
        System.out.println("第二部，调用该set方法");
    }

    //创建执行的初始化的方法
    public void initMethod(){
        System.out.println("第三步，执行初始化方法");
    }

    @Override
    public String toString() {
        return "Orders{" +
                "name='" + name + '\'' +
                '}';
    }
}
