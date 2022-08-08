package com.dongchao.Thread.Tools;


import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class UseCyclicBarrier {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    public static void main(String[] args) {
        for(int i=0;i<=4;i++){
            Thread thread = new Thread(new SubThread());
            thread.start();
        }

    }

    private static class SubThread implements Runnable {

        @Override
        public void run() {
            long id = Thread.currentThread().getId();//线程本身的处理结果
            Random r = new Random();//随机决定工作线程的是否睡眠
            try {
                if (r.nextBoolean()) {
                    Thread.sleep(2000 + id);
                    System.out.println("Thread_" + id + " ....do something ");
                }
                System.out.println(id + "....is await");
                cyclicBarrier.await();
                Thread.sleep(1000 + id);
                System.out.println("Thread_" + id + " ....do its business ");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}

