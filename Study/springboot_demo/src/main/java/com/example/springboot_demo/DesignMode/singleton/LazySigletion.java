package com.example.springboot_demo.DesignMode.singleton;

/**
 * 单例模式-懒汉式
 */
public class LazySigletion {
    //定义变量
    private static LazySigletion lazySigletion = null;
    //隐藏起构造方法
    private LazySigletion() {
    }
    //提供对外访问的方法
    public static LazySigletion getInstance() {
        if (lazySigletion == null) {
            return new LazySigletion();
        } else {
            return lazySigletion;
        }
    }
}
