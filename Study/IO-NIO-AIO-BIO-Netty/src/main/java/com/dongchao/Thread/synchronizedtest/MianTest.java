package com.dongchao.Thread.synchronizedtest;

import java.util.concurrent.CountDownLatch;

public class MianTest {
    public static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        User user = new User("dongzhichao", 23);
        User user2 = new User("dongzhichao", 23);

        Thread thread = new Thread(new RunnavleTest(user, countDownLatch));
        Thread thread2 = new Thread(new RunnavleTest2(user, countDownLatch));
        thread.start();
        thread2.start();

        countDownLatch.await();

        System.out.println("main方法结束执行");

    }


    public static class RunnavleTest implements Runnable {
        private User user;
        private CountDownLatch countDownLatch;

        RunnavleTest(User user, CountDownLatch countDownLatch) {
            this.user = user;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                user.sync2_method();
//                user.class_method();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            countDownLatch.countDown();

        }
    }

    public static class RunnavleTest2 implements Runnable {
        private User user;
        private CountDownLatch countDownLatch;

        RunnavleTest2(User user, CountDownLatch countDownLatch) {
            this.user = user;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                user.sync2_method();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            countDownLatch.countDown();
        }
    }
}
