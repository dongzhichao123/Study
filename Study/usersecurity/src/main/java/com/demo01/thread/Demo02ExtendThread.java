package com.demo01.thread;

/**
 * @author dong
 * @title: Demo02ExtendThread
 * @projectName usersecurity
 * @description: TODO
 * @date 2022/5/11 1:58
 **/
public class Demo02ExtendThread extends  Thread {
    @Override
    public void run() {
        System.out.println("我是继承Thread"+Thread.currentThread().getName());
    }
}
