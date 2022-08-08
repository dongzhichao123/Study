package com.myspring.service;

import com.myspring.config.MyBeanPostFactory;
import com.myspring.config.MyComponent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@MyComponent
public class TestBeanPostFactory implements MyBeanPostFactory {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if (beanName.equals("TestService")){
            System.out.println("初始化前");

        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if (beanName.equals("TestService")){
            System.out.println("初始化后");
            Object o = Proxy.newProxyInstance(TestBeanPostFactory.class.getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {

                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("代理逻辑");

                    return   method.invoke(bean,args);
                }
            });
            return o ;

        }
        return bean;
    }
}
