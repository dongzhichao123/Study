package com.demo01.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author dong
 * @title: ThreadDemo02
 * @projectName usersecurity
 * @description: TODO
 * @date 2022/5/11 1:58
 **/
public class ThreadDemo02 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println(Thread.currentThread().getName());
        Demo02ExtendThread demo02ExtendThread = new Demo02ExtendThread();
        demo02ExtendThread.start();
        new Thread() {
            @Override
            public void run() {
                System.out.println("我是内部类" + Thread.currentThread().getName());
            }
        }.start();
        ThreadRunnable threadRunnable = new ThreadRunnable();
        Thread thread = new Thread(threadRunnable);
        thread.start();

        ThreadCallable threadCallable = new ThreadCallable(1);
        FutureTask<String> stringFutureTask = new FutureTask<>(threadCallable);
        Thread thread1 = new Thread(stringFutureTask);
        thread1.start();
        System.out.println("提前完成任务...");
        //获取任务执行后返回的结果
        String result = stringFutureTask.get();
        System.out.println("线程执行结果为"+result);
    }
}
