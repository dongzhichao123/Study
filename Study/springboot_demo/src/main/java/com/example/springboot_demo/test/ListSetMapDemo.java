package com.example.springboot_demo.test;

import org.springframework.beans.factory.annotation.Value;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/*
List Set Map 的实例
 */
public class ListSetMapDemo {
    @Value("spring.datasource.username")
    private static String user;

    public static void main(String[] args) {
//        ResourceBundle application = ResourceBundle.getBundle("application");
//        System.out.println(application.getString("spring.datasource.username"));

        System.out.println(new Integer(0));
//        ArrayList<Integer> strings = new ArrayList<>();
//        strings.add(5);
//        strings.add(6);
//        strings.add(7);
//        Iterator<String> iterator = strings.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//        Map<String, String> collect = strings.stream().collect(Collectors.toMap(String::toString, String::toString));
//        System.out.println(collect);

//        LinkedList<Integer> integers = new LinkedList<>();
//        integers.add(1);
//        integers.add(2);
//        integers.add(3);
//
//        integers.add(1,4);
//        integers.addAll(1,strings);
//        Iterator<Integer> iterator1 = integers.stream().iterator();
//        Iterator<Integer> iterator = integers.iterator();
//        while (iterator1.hasNext()){
//            System.out.println(iterator1.next());
//        }
//        TreeSet<Integer> integers = new TreeSet<>();
//        integers.add(1);
//        integers.add(1);
//        integers.add(2);
//        integers.add(3);
//        integers.add(4);
//        integers.add(5);
//        System.out.println(integers.pollFirst());
//        System.out.println(integers);
//        System.out.println(integers.first());
//        System.out.println(integers);

//        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
//        HashMap<String, String> map = new HashMap<>();
//        map.put("1", "1");
//        map.put("2", "2");
//        map.put("3", "3");
////        ThreadLocal<HashMap> hashMapThreadLocal = new ThreadLocal<>();
////        hashMapThreadLocal.set(map);
//        new Thread(new testTwoThread(map)).start();
//        new Thread(new testTwoThread(map)).start();

    }

    public static void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 如果不存在 session 会话，则创建一个 session 对象
        HttpSession session = request.getSession(true);


        session.setAttribute("visitCountKey", new Integer(0));

        Integer visitCount = (Integer) session.getAttribute("visitCountKey");
        System.out.println(visitCount);
    }

    static class testThread implements Runnable {

        /**
         *
         */
        private ConcurrentHashMap map;

        public testThread(ConcurrentHashMap map) {
            this.map = map;
        }

        @Override
        public void run() {
            map.put("1", "2");
            System.out.println(map.get("1"));


            try {
                Thread.sleep(1000);
                System.out.println("线程结束");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class testTwoThread implements Runnable {

        /**
         *
         */
        private ThreadLocal<HashMap> threadLocal = new ThreadLocal<HashMap>();

        private HashMap map;

        public testTwoThread(HashMap map) {
            threadLocal.set(map);
        }

        @Override
        public void run() {

            threadLocal.get().put("1", "2");
            System.out.println(map.get("1"));


            try {
                Thread.sleep(1000);
                System.out.println("线程结束");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }


}
