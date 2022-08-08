package com.myspring;

import com.myspring.config.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class DzcApplication {
    private Class configClass;
    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Object> beanDefinitionMap = new ConcurrentHashMap<>();
    private List<MyBeanPostFactory> postList = new ArrayList<MyBeanPostFactory>();

    public DzcApplication(Class configClass) throws IOException, ClassNotFoundException {
        this.configClass = configClass;
        //扫描文件生成beandefinition放入map中
        scan(configClass);

//        System.out.println(beanDefinitionMap);
        Enumeration<String> keys = beanDefinitionMap.keys();
        while (keys.hasMoreElements()) {
            String beanname = keys.nextElement();
            MyBeanDefinition myBeanDefinition = (MyBeanDefinition) beanDefinitionMap.get(beanname);
            if ("singleton".equals(myBeanDefinition.getScope())) {
                Object o = creat(beanname, myBeanDefinition);
                singletonObjects.put(beanname, o);
            }
        }


    }

    private Object creat(String beanName, MyBeanDefinition myBeanDefinition) {
        Class clazz = myBeanDefinition.getClazz();
        try {
            Object o = clazz.getDeclaredConstructor().newInstance();
            //依赖注入
            for (Field declaredField : clazz.getDeclaredFields()) {
                if (declaredField.isAnnotationPresent(MyAutowired.class)) {
                    System.out.println(declaredField.getName());
                    declaredField.setAccessible(true);
                    declaredField.set(o, getBean(declaredField.getName()));
                }
            }
            for (MyBeanPostFactory o1 : postList) {
                o = o1.postProcessBeforeInitialization(o, beanName);
            }
            //初始化
            if (o instanceof MyInitializingBean) {
                MyInitializingBean MyInitializingBean = (com.myspring.config.MyInitializingBean) o;
                MyInitializingBean.afterPropertiesSet();
            }
            for (MyBeanPostFactory o1 : postList) {
                o = o1.postProcessAfterInitialization(o, beanName);
            }
            return o;
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }

    private void scan(Class configClass) throws ClassNotFoundException {
        //获取到自定义的扫描路径
        System.out.println("获取自定义的扫描路径");
        MyCompontScan myCompontScan = (MyCompontScan) configClass.getDeclaredAnnotation(MyCompontScan.class);
        String path = myCompontScan.value();

        System.out.println("扫描路径为：" + path);
        //开始扫描
        System.out.println("开始扫描");
        System.out.println("更具包查找所有的类");
        //通过当前类的一个类加载器获取到一个文件路径
        ClassLoader classLoader = DzcApplication.class.getClassLoader();
        URL resources = classLoader.getResource(URLUtils.reURL(path));
//        System.out.println(resources);
        File file = new File(resources.getFile());
        //判断file是否是一个路径
        if (file.isDirectory()) {
//            System.out.println(file.getAbsolutePath() + "是一个文件");
            File[] files = file.listFiles();
            for (File file1 : files) {
//                System.out.println(file1);
                String absolutePath = file1.getAbsolutePath();
//                System.out.println(absolutePath);
                if (absolutePath.endsWith(".class")) {
                    String com = absolutePath.substring(absolutePath.indexOf("com"), absolutePath.indexOf(".class")).replace("\\", ".");
                    System.out.println(com);
                    Class<?> aClass = classLoader.loadClass(com);

                    if (aClass.isAnnotationPresent(MyComponent.class)) {
                        MyComponent myComponent = aClass.getDeclaredAnnotation(MyComponent.class);
                        System.out.println(myComponent.value());
                        System.out.println(aClass.getSimpleName());
                        String beanName = myComponent.value().isEmpty() ? aClass.getSimpleName() : myComponent.value();
                        System.out.println("beanName:" + beanName);
                        MyScope myScope = aClass.getDeclaredAnnotation(MyScope.class);

                        String scope;
                        if (myScope == null) {
                            scope = "singleton";
                        } else {
                            scope = myScope.value();
                        }
                        System.out.println("Scope:" + scope);
                        MyBeanDefinition myBeanDefinition = new MyBeanDefinition(aClass, scope);
                        if (MyBeanPostFactory.class.isAssignableFrom(aClass)) {
                            System.out.println(myBeanDefinition);
                            MyBeanPostFactory postBean = (MyBeanPostFactory) creat(beanName, myBeanDefinition);
                            postList.add(postBean);
                        }
                        beanDefinitionMap.put(beanName, myBeanDefinition);
                    }
                }
            }
        }
    }

    public Object getBean(String beanName) {
        if (beanDefinitionMap.containsKey(beanName)) {
            MyBeanDefinition myBeanDefinition = (MyBeanDefinition) beanDefinitionMap.get(beanName);
            if ("singleton".equals(myBeanDefinition.getScope())) {
                Object o = singletonObjects.get(beanName);
                return o;
            } else {
                return creat(beanName, myBeanDefinition);
            }
        } else {
            throw new NullPointerException();
        }
    }
}
