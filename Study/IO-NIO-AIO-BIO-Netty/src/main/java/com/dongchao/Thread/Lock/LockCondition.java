package com.dongchao.Thread.Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCondition {
    public static volatile int count = 10;
    static Lock lock = new ReentrantLock();
    static Condition conditiona = lock.newCondition();
    static Condition conditionb = lock.newCondition();

    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            new Thread(new CountDowmTest()).start();
        }
        new Thread(new ReadCountTest()).start();
        for (int i = 0; i < 5; i++) {
            new Thread(new TrheeTest()).start();
        }

    }

    public static class ReadCountTest implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try {
                if (count > 5) {
                    System.out.println("Read 开始等");

                    conditiona.await();


                } else {
                    System.out.println("hello world");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }

    public static class CountDowmTest implements Runnable {
        @Override
        public void run() {

            lock.lock();
            try {
                if (count > 5) {
                    count = count - 1;
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "CountDowmTest  count:" + count);

                } else {
                    System.out.println("开始唤醒read");
                    conditiona.signal();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }


        }
    }


    public static class TrheeTest implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                if (count <= 5) {
                    count = count - 1;
                    System.out.println(Thread.currentThread().getName() + "TrheeTest  count:" + count);
                } else {
                    System.out.println("TrheeTest线程开始进行等待");
                }

            } finally {
                lock.unlock();
            }

        }
    }
}
