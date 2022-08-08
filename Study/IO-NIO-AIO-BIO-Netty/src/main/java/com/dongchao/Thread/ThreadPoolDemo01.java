package com.dongchao.Thread;

import java.util.Random;
import java.util.concurrent.*;

public class ThreadPoolDemo01 {
    public static int number=0;
    public static CountDownLatch countDownLatch=new CountDownLatch(20);
    public static void main(String[] args) throws InterruptedException {
        /*
        public ThreadPoolExecutor(     @Range(from = 0, to = Integer.MAX_VALUE)  int corePoolSize,
    @Range(from = 1, to = Integer.MAX_VALUE)  int maximumPoolSize,
    @Range(from = 0, to = Long.MAX_VALUE)  long keepAliveTime,
    @NotNull  TimeUnit unit,
    @NotNull  BlockingQueue<Runnable> workQueue )
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,10,1,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(10));
        for (int i = 0; i < 20; i++) {
            RunnableTest runnableTest=new RunnableTest();
              threadPoolExecutor.execute(runnableTest);
        }
        countDownLatch.await();
        System.out.println("number="+number);
    }
     public static class RunnableTest implements Runnable{

         @Override
         public void run() {
             try {
                 Random random=new Random();
                 System.out.println("进入线程："+Thread.currentThread().getName());
                 Thread.sleep(10000);
                 System.out.println("结束线程："+Thread.currentThread().getName());

                 add();
                 countDownLatch.countDown();
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
         }
     }

     public static synchronized void add(){
        number++;
     }


}
