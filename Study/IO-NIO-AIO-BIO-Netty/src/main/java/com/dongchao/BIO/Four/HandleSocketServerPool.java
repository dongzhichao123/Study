package com.dongchao.BIO.Four;

import java.util.concurrent.*;

/**
 * 线程池
 */
public class HandleSocketServerPool {
    //1.创建一个线程池的成员变量
    private ExecutorService executorService;

    /**
     * 创建这个类对象的时候就需要出池化线程池对象
     */
    public HandleSocketServerPool(int maxThreadNum, int queueSize) {
 /* public ThreadPoolExecutor(
        int corePoolSize,核心线程数量
        int maximumPoolSize,最大线程数
        long keepAliveTime,线程空闲时间
        TimeUnit unit,空闲时间单位
        BlockingQueue<Runnable> workQueue)*/
        executorService = new ThreadPoolExecutor(3, maxThreadNum, 120, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(queueSize));
    }

    /**
     * 提供一个方法来提交任务给线程池的任务队列来暂存，等待线程来进行处理
     */
    public void execute(Runnable target){
        executorService.execute(target);
    }
}
