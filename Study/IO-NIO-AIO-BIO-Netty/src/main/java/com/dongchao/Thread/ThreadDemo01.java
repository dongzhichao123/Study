package com.dongchao.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ThreadDemo01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RunnableThread runnableThread = new RunnableThread("董智超");
        System.out.println("主线程名称：" + Thread.currentThread().getName());
        new Thread(runnableThread).start();
        CallableThread callableThread = new CallableThread("callable");
        FutureTask futureTask = new FutureTask(callableThread);
        new Thread(futureTask).start();
        System.out.println("接受到的返回信息为：" + futureTask.get());
        Thread thread=new ThreadText();
        thread.start();
    }
  public static class ThreadText extends Thread{
      @Override
      public void run() {
          System.out.println("我是继承线程Thread");
      }
  }
    public static class RunnableThread implements Runnable {
        private String name;

        public RunnableThread(String ss) {
            this.name = ss;
        }

        @Override
        public void run() {
            System.out.println("我是线程Runnable-" + Thread.currentThread().getName() + ":" + name);
        }
    }

    public static class CallableThread implements Callable {
        private String name;

        public CallableThread(String name) {
            this.name = name;
        }

        @Override
        public Object call() throws Exception {
            System.out.println("我是线程Callable-" + Thread.currentThread().getName() + ":" + name);

            return "返回数据-hello我";
        }
    }
}
