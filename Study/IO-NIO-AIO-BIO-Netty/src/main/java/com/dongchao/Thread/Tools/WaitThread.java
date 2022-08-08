package com.dongchao.Thread.Tools;

import java.util.concurrent.CountDownLatch;

public class WaitThread implements Runnable{
    private CountDownLatch countDownLatch;
    public WaitThread (CountDownLatch countDownLatch){
        this.countDownLatch=countDownLatch;
    }
    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i =0;i<3;i++) {
            System.out.println("BusiThread_"+Thread.currentThread().getId()
                    +" do business-----");
        }
    }
}
