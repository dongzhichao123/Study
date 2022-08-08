package com.dongchao.Thread.Tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @Author: thunder
 * @Date: 2020/7/26 11:22
 */

public class TestSynchronized  {


    public static void main(String args[]) throws InterruptedException {

        //自定义线程池
        ExecutorService executorService  =  new ThreadPoolExecutor(10,20,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(10));
        //定义线程计数器的初始数量，每一个线程完成，调用downLatch.countDown()减1
        CountDownLatch latch             =  new CountDownLatch(2);

        //创建TestData对象
        TestData testdata   = new TestData();
        TestData testdata1  = new TestData();
        //TestData testdata2  = new TestData();

        //创建线程实例
        TestMythead t1  = new TestMythead("Thread-1",latch,testdata);
        TestMythead2 t2  = new TestMythead2("Thread-2",latch,testdata);

        //提交任务到线程池
        executorService.execute(t1);
        executorService.execute(t2);
        //线程等待，唤醒主线程，继续执行
        latch.await();
        //关闭线程池,释放资源
        executorService.shutdown();
        System.out.println(Thread.currentThread().getName()+"-hello,我又回来了");
    }

}

class TestMythead implements Runnable{

    private Thread t;
    private String threadName;
    private CountDownLatch downLatch;//线程计数器
    private final TestData testData;

    //构造方法
    TestMythead(String name,CountDownLatch downLatch,TestData data){
        this.threadName = name;
        this.downLatch  = downLatch;
        this.testData   = data;
    }

    //定义线程体
    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+"-正在执行...");

        //synchronized 作用于一个对象实例时，锁住的是**所有以该对象为锁的代码块**。如果其他代码块，没有以该对象为锁，则可以访问该对象的非synchronized 方法。
        synchronized (testData){

            System.out.println(Thread.currentThread().getName()+"-进入了修饰的代码块~");

            try {

                testData.test_Object();
                //this.testData.test_sync();
                //this.testData.test_sync_code();
                //TestData.test_sync_static();//class实例直接调用静态方法
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //完成任务计数器减1
            this.downLatch.countDown();

        }


    }

    //直接实现runable接口需要同时定义run()和start(),才能执行
    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this,threadName);
            t.start ();
        }
    }

}



//定义别的线程
class TestMythead2 extends Thread{

    private String threadName;
    private CountDownLatch downLatch;//线程计数器
    private TestData testData;

    //构造方法
    TestMythead2(String name,CountDownLatch downLatch,TestData data){
        this.threadName = name;
        this.downLatch  = downLatch;
        this.testData   = data;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+"-正在执行...");
        //未以此对象为锁时，可以访问对象的非synchronized方法，已此对象为锁时，线程进入了阻塞状态
        //synchronized (TestData.class) {
        try {
            //可以并发访问没有Synchronized修饰的方法
            //testData.test_sync();
            testData.test_Object();
            //TestData.test_sync_static();//class实例直接调用静态方法
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //完成任务计数器减1
        this.downLatch.countDown();
        // }

    }

}



class  TestData{


    //Synchronized修饰方法时，锁住的是对象实例，如果是不同的对象实例，则锁不住
    public synchronized void test_sync() throws InterruptedException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(Thread.currentThread().getName()+"-进入synchronized修饰方法-"+df.format(new Date()));
        Thread.sleep(5000);
    }

    public  void test_Object() throws InterruptedException {
        synchronized(TestData.class){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            System.out.println(Thread.currentThread().getName()+"-进入synchronized test_Object修饰方法-"+df.format(new Date()));
            Thread.sleep(5000);
        }

    }
    public synchronized void test_syn2() throws InterruptedException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(Thread.currentThread().getName()+"-进入synchronized2修饰方法-"+df.format(new Date()));
        Thread.sleep(5000);
    }
    //定义方法体,锁住的是对象实例，如果是不同的对象实例，则锁不住
    public void test_sync_code() throws InterruptedException {
        synchronized (this){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            System.out.println(Thread.currentThread().getName()+"-进入synchronize代码块-"+df.format(new Date()));
            Thread.sleep(5000);
        }
    }

    //定义Synchronized修饰静态方法时，锁住的是class实例，class实例都会被锁住
    public synchronized static void test_sync_static() throws InterruptedException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(Thread.currentThread().getName()+"-进入synchronized修饰的静态方法-"+df.format(new Date()));
        Thread.sleep(5000);
    }

    //定义没有Synchronized修饰的方法,别的线程可以访问该对象的非synchronized代码块而不受阻塞
    public void test_no_sync() throws InterruptedException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(Thread.currentThread().getName()+"-进入没有synchronized修饰的方法-"+df.format(new Date()));
        Thread.sleep(5000);
    }

}
