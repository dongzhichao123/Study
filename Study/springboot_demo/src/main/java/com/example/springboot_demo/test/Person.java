package com.example.springboot_demo.test;

import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Person {
    static int arr[] = new int[5];

    public static void main(String[] as) throws ClassNotFoundException {
        Test2 test=new Test2();
        test.g();
        TestOne testOne = new TestOne();
        testOne.tt();
        TestOneProxy testOneProxy = new TestOneProxy(testOne);
        ClassLoader classLoader = testOne.getClass().getClassLoader();
        Class<?>[] interfaces = testOne.getClass().getInterfaces();
        System.out.println(interfaces.length);

        TestInterface o = (TestInterface) Proxy.newProxyInstance(classLoader, interfaces, testOneProxy);
        System.out.println("动态代理对象的类型：" + o.getClass().getName());
        o.pp(10);
    }
   static class Test2
    {
        public  void g(){
            gg();
        }
        public  void gg(){
            System.out.println("-1 : "+Reflection.getCallerClass(-1));
            System.out.println("0 : "+Reflection.getCallerClass(0));
            System.out.println("1 : "+Reflection.getCallerClass(1));
            System.out.println("2 : "+Reflection.getCallerClass(2));
            System.out.println("3 : "+Reflection.getCallerClass(3));
            System.out.println("4 : "+Reflection.getCallerClass(4));
            System.out.println("5 : "+Reflection.getCallerClass(5));
        }

    }

    /**
     * 动态代理类与真实类共同的接口
     *
     * @param <T>
     */
    static interface TestInterface<T> {
        public <T> void pp(T value);
    }

    /**
     * 真实类
     */
    static class TestOne implements TestInterface {
        @Override
        public void pp(Object value) {
            System.out.println(value);
        }

        public void tt() {

        }
    }

    static class TestOneProxy implements InvocationHandler {

        private Object realClass;

        public TestOneProxy(Object o) {
            this.realClass = o;
        }

        /**
         * @Param proxy 动态代理类
         * @Param method 调用的方法
         * @Param args 传递进来的参数
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("动态代理之前:" + method.getName());

            Object invoke = method.invoke(realClass, args);
            System.out.println("动态代理之后");
            return invoke;
        }
    }

}

