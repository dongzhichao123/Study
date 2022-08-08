package com.dongchao.Thread.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用显示锁的范式
 */
public class LockDemo {
    public Lock lock = new ReentrantLock();
    private int count;
    public void increament() {
        try {
            lock.lockInterruptibly();
            try{

            }finally {
                lock.unlock();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void incr2() {
        count++;
    }
}
