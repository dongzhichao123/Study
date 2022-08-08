package com.dongchao.Thread;

public class VolatieTest {
    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };
    private static volatile int a = 0;

    public static void main(String[] args) {
        ThreadLoadRunnable volatieRunnable = new ThreadLoadRunnable();
        Thread thread1 = new Thread(volatieRunnable);
        Thread thread2 = new Thread(volatieRunnable);
        Thread thread3 = new Thread(volatieRunnable);
        Thread thread4 = new Thread(volatieRunnable);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }

    public static class VolatieRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            a = a + 1;
            System.out.println(Thread.currentThread().getName() + "--a:" + a);
            try {
                Thread.sleep(100);
                a = a + 1;
                System.out.println(Thread.currentThread().getName() + "--a:" + a);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static class ThreadLoadRunnable implements Runnable {


        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            Integer a = threadLocal.get();
            System.out.println(Thread.currentThread().getName() + "--a:" + a);
            a = a + 1;
            threadLocal.set(a);
            System.out.println(Thread.currentThread().getName() + "--a:" + threadLocal.get());


        }
    }
}
