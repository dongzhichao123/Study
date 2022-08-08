package com.dongchao.Thread.Tools;

import java.util.concurrent.CountDownLatch;

public class UseCountDownLatch {
    private static CountDownLatch countDownLatch = new CountDownLatch(6);

    public static void main(String[] args) {
        System.out.println("mian 线程开始运行");
        new Thread(new WaitThread(countDownLatch)).start();
        for(int i=0;i<=5;i++){
            Thread thread = new Thread(new InitThread(countDownLatch));
            thread.start();
        }
    }


}
