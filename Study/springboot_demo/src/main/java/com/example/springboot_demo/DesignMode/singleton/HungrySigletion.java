package com.example.springboot_demo.DesignMode.singleton;

/**
 * 单例模式-饿汉式
 */
public  class HungrySigletion {
    //在类的加载过程中就创建好了对象
    private static HungrySigletion hungrySigletion = new HungrySigletion();
    private HungrySigletion() {
    }
    //提供一个对外访问的接口
    public static HungrySigletion getInstance() {
        if (hungrySigletion == null) {
            return new HungrySigletion();
        } else {
            return hungrySigletion;
        }
    }
    public static void main(String[] args) {
        System.out.println(HungrySigletion.getInstance());
        System.out.println(HungrySigletion.getInstance());
        System.out.println(HungrySigletion.getInstance());
    }
}
