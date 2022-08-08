package com.dongchao.Thread.synchronizedtest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    //类锁
    public synchronized static void static_method() throws InterruptedException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

        System.out.println("static_method：" + Thread.currentThread().getName() + "   时间：" + df.format(new Date()));
        Thread.sleep(5000);
    }

    public void class_method() throws InterruptedException {
        synchronized (User.class) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

            System.out.println("class_method：" + Thread.currentThread().getName() + "   时间：" + df.format(new Date()));
            Thread.sleep(5000);
        }
    }

    //对象锁
    public synchronized void sync_method() throws InterruptedException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

        System.out.println("sync_method：" + Thread.currentThread().getName() + "   时间：" + df.format(new Date()));
        Thread.sleep(5000);
    }

    public synchronized void sync2_method() throws InterruptedException {
        synchronized (this) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

            System.out.println("sync_method：" + Thread.currentThread().getName() + "   时间：" + df.format(new Date()));
            Thread.sleep(5000);
        }
    }

    public void nosync_method() throws InterruptedException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

        System.out.println("nosync_method：" + Thread.currentThread().getName() + "   时间：" + df.format(new Date()));
        Thread.sleep(5000);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
