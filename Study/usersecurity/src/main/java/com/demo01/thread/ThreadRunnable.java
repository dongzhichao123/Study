package com.demo01.thread;

/**
 * @author dong
 * @title: ThreadRunnable
 * @projectName usersecurity
 * @description: TODO
 * @date 2022/5/11 2:01
 **/
public class ThreadRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("我是Runnable"+Thread.currentThread().getName());
    }
}
