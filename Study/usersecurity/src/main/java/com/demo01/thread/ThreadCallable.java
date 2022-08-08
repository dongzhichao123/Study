package com.demo01.thread;

import java.util.concurrent.Callable;

/**
 * @author dong
 * @title: ThreadCallable
 * @projectName usersecurity
 * @description: TODO
 * @date 2022/5/11 2:07
 **/
public class ThreadCallable implements Callable<String> {
    private int i;

    ThreadCallable(int i1) {
        this.i = i1;
    }

    @Override
    public String call() throws Exception {
        System.out.println("正在执行新建线程任务");
        Thread.sleep(2000);
        return "新建线程睡了2s后返回执行结果"+"++++++++"+(i+1);
    }
}
