package com.dongchao.Thread.Tools;

import java.util.concurrent.CountDownLatch;

public class InitThread implements Runnable{
    private CountDownLatch countDownLatch;
    public InitThread (CountDownLatch countDownLatch){
        this.countDownLatch=countDownLatch;
    }
    @Override
    public void run() {
        System.out.println("Thread_"+Thread.currentThread().getId()
                +" ready init work......");
        for(int i =0;i<2;i++) {
            System.out.println("Thread_"+Thread.currentThread().getId()
                    +" ........continue do its work");
        }
        countDownLatch.countDown();//初始化线程完成工作了，countDown方法只扣减一次；

    }
}
