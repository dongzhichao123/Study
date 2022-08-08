package com.example.springboot_demo;

import com.alibaba.fastjson.JSONObject;
import com.example.springboot_demo.Mybatis.entity.Person;
import com.example.springboot_demo.Mybatis.entity.User;
import com.example.springboot_demo.Mybatis.service.Myservice;
import com.example.springboot_demo.MybatisXml.UserXmlMapper;
import com.example.springboot_demo.rabbitmq.one.Sender;
import com.example.springboot_demo.rabbitmq.two.RabbitSend;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.*;
import java.util.stream.Stream;

@SpringBootTest
class SpringbootDemoApplicationTests {
    @Autowired
    UserXmlMapper userXmlMapper;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    Myservice myservice;
    @Autowired
    RabbitSend rabbitSend;
    @Value("spring.datasource.username")
    String user;

    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Autowired
    private Sender rabbitMessagingTemplate;

    public static void main(String[] args) {
        System.out.println(fun(5));
    }

    public static int fun(int n) {
        if (n < 2) {
            return n;
        }
        return fun(n - 1) + fun(n - 2);
    }

    @Test
    void valueTest() {
        System.out.println(user);
    }

    @Test
    void contextLoads() {
        List<User> userList = userXmlMapper.selectAll();

//
//        for (User user : userList) {
////           redisTemplate.delete(user.getId());
////
//////
//            redisTemplate.opsForValue().set(user.getId(), user);
//            redisTemplate.expire(user.getId(), 10, TimeUnit.SECONDS);
//        }
//
//        System.out.println(redisTemplate.opsForValue().get(1));

//
//        redisTemplate.opsForList().rightPush("list",1);
//        redisTemplate.opsForList().rightPush("list",2);
//        redisTemplate.opsForList().rightPush("list",3);
//        ConcurrentHashMap

//        System.out.println(redisTemplate.opsForList().size("list"));
//        System.out.println(redisTemplate.opsForList().index("list", 0));


    }

    @Test
    void contextLoads2() {
        User user = new User();
        user.setAge(20);
        user.setName("hhhh");
        userXmlMapper.addUser(user);
    }

    @Test
    void contextLoads3() {
        User user = new User(3, "asd", 44);
        int i = userXmlMapper.updaterUser(user);
        if (i > 0) {
            redisTemplate.opsForValue().set(user.getId(), user);
        }
    }

    @Test
    void contextLoads4() {
        User user = userXmlMapper.selectByName("11");
        System.out.println(user);
    }

    @Test
    void rabbitMqTestOne() {
//        rabbitMessagingTemplate.sendDirect();
//        rabbitMessagingTemplate.sendTopic();
//        rabbitMessagingTemplate.sendFanout();
        rabbitTemplate.convertAndSend("ackexchange", "testack.one", "测试ack");
    }

    @Test
    void pageINfotest() {
        PageInfo<User> pageInfo = myservice.selectAllByPageInfo(2, 2);
        List<User> userList = pageInfo.getList();
        System.out.println("数量：" + pageInfo.getSize());
        System.out.println("数据：" + userList);

    }

    @Test
    void Rabbit() {
//        rabbitSend.TestOne("woshiceshi yi");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "sssssssss");
        rabbitSend.TestTwo(jsonObject);
//        rabbitSend.TestThree(jsonObject);
    }

    @Test
    void StreamTest() {

        List<Person> personList = new ArrayList<Person>();
//        personList.add(new Person("Tom", 8900, 22, "male", "New York"));
//        personList.add(new Person("Jack", 7000, 23, "male", "Washington"));
//        personList.add(new Person("Lily", 7800, 33, "female", "Washington"));
//        personList.add(new Person("Anni", 8200, 32, "female", "New York"));
//        personList.add(new Person("Owen", 9500, 34, "male", "New York"));
//        personList.add(new Person("Alisa", 7900, 25, "female", "New York"));
        Stream<Person> personStream = personList.stream();
        //for循环
//        personStream.forEach(System.out::println);

        //获取第一个人员
//        Optional<Person> first = personStream.findFirst();
//        System.out.println(first.get());

        //查找指定元素
//        Stream<Person> personStream1 = personStream.filter(person -> person.getName().equals("Tom"));
//        personStream1.forEach(System.out::println);

        //是否包含
//        boolean b = personStream.anyMatch(person -> person.getAge() == 25);
//        System.out.println(b);

//筛选员工中工资高于8000的人，并形成新的集合
//        Stream<Person> personStream1 = personStream.filter(person -> person.getSalary() > 8000);
//        List<String> collect = personStream1.map(Person::getName).collect(Collectors.toList());
//        System.out.println(collect);

        //max
//        Optional<Person> max = personStream.max(Comparator.comparing(Person::getSalary));
//        System.out.println(max.get());

        //min
//        System.out.println(personStream.min(Comparator.comparing(Person::getSalary)).get());

        //count  筛选员工中工资高于8000的人数
//        System.out.println(personStream.filter(person -> person.getSalary() > 8000).count());

        //映射(map/flatMap)
//        映射，可以将一个流的元素按照一定的映射规则映射到另一个流中。分为map和flatMap：
//map：接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
//flatMap：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
//        String[] strArr = {"abcd", "bcdd", "defde", "fTr"};
//        List<String> strList = Arrays.stream(strArr).map(String::toUpperCase).collect(Collectors.toList());
//        System.out.println(strList);
//        List<Integer> intList = Arrays.asList(1, 3, 5, 7, 9, 11);
//        List<Integer> intListNew = intList.stream().map(x -> {
//            if (x < 9) {
//                return x + 3;
//            }
//            return x;
//        }).collect(Collectors.toList());
//
//        System.out.println(intListNew);
        // 将员工的薪资全部增加1000。
//        System.out.println(personStream.map(person -> {
//            person.setSalary(person.getSalary() + 1000);
//            return person;
//        }).collect(Collectors.toList()));


        //list->map
//        Map<String, Integer> collect = personStream.collect(Collectors.toMap(Person::getName, Person::getSalary));
//        System.out.println(collect.get("Tom"));
/*        归约(reduce)
        归约，也称缩减，顾名思义，是把一个流缩减成一个值，能实现对集合求和、求乘积和求最值操作。*/

        //求Integer集合的元素之和、乘积和最大值。
//        List<Integer> list = Arrays.asList(1, 3, 2, 8, 11, 4);
//        System.out.println(list.stream().reduce(Integer::sum).get());
//        System.out.println(list.stream().reduce((x, y) -> x + y).get());
//        System.out.println(list.stream().reduce((x, y) -> x * y).get());
//        System.out.println(list.stream().reduce(Integer::max).get());
//        System.out.println(list.stream().max(Comparator.comparing(Integer::intValue)).get());

        //求所有员工的工资之和和最高工资。\
//        System.out.println(personStream.map(Person::getSalary).reduce(Integer::sum).get());
//        System.out.println(personStream.max(Comparator.comparing(Person::getSalary)).get().getSalary());
//        System.out.println(personStream.map(Person::getSalary).reduce(Integer::max).get());

        //收集 collect
        //tomap
//        System.out.println(personStream.collect(Collectors.toMap(Person::getName, person -> person)));

        //Collectors提供了一系列用于数据统计的静态方法：
        //
        //计数：count
        //平均值：averagingInt、averagingLong、averagingDouble
        //最值：maxBy、minBy
        //求和：summingInt、summingLong、summingDouble
        //统计以上所有：summarizingInt、summarizingLong、summarizingDouble

//        System.out.println(personStream.collect(Collectors.counting()));
//        System.out.println(personStream.collect(Collectors.averagingDouble(Person::getSalary)));
//        System.out.println(personStream.max(Comparator.comparing(Person::getSex)).get());

//        DoubleSummaryStatistics collect = personList.stream().collect(Collectors.summarizingDouble(Person::getSalary));
//        System.out.println(collect);

        //分组(partitioningBy/groupingBy)

//        System.out.println(personStream.collect(Collectors.partitioningBy(person -> person.getSalary() > 7000)));
//        System.out.println(personStream.collect(Collectors.groupingBy(person -> person.getSex())));

        //接合(joining)
//        System.out.println(personStream.map(person -> person.getName()).collect(Collectors.joining("_")));

        // 归约(reducing)
//        List<Integer> list = Arrays.asList(1, 3, 2, 8, 11, 4);
//        // 求和方式1
//
//        // 求和方式3
//        System.out.println(list.stream().reduce(1, Integer::sum));

        personStream.reduce(0, (sum, p) -> sum += p.getSalary(), (sum1, sum2) -> sum1 + sum2);

    }

    @Test
    void ExcelTest() {
        String hash = "222";
        Integer integer = 222;
        System.out.println(Integer.toString(1, 3));
        System.out.println(hash.hashCode());
        System.out.println(integer.hashCode());

    }

    public int minNumberDisappeared(int[] nums) {
        // write code here
        int minint = Arrays.stream(nums).min().getAsInt();
        int maxint = Arrays.stream(nums).max().getAsInt();
        Map map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int result = minint;
        while (result >= minint) {
            result++;
            if (!map.containsKey(result)) {
                return result;
            }
        }
        return 0;

    }

    @Test
    void testtt() {
        int[] arr1 = {1, 2};
        int[] arr2 = {3, 4};
        findMedianinTwoSortedAray(arr1, arr2);
    }

    public int findMedianinTwoSortedAray(int[] arr1, int[] arr2) {
        int[] a = new int[arr1.length * 2];
        for (int i = 0; i < arr1.length; i++) {
            a[i] = arr1[i];
        }
        for (int i = 0; i < arr1.length; i++) {
            a[i + arr1.length] = arr2[i];
        }
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (a[i] > a[j]) {
                    int s = a[i];
                    a[i] = a[j];
                    a[j] = i;
                }
            }
        }
        return a[a.length / 2];
    }

    @Test
    public void test() {
        rabbitTemplate.convertAndSend("aaa", "sssss", "testtesttesttest", new MessagePostProcessor() {
            /**
             * @param message
             * @return
             * @throws AmqpException
             */
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setCorrelationId(UUID.randomUUID().toString());
                return message;
            }


        });
    }


    @Test
    public void RedisTest() {
//        redisTemplate.opsForList().rightPush("queueList",1);
//        redisTemplate.opsForList().rightPush("queueList",2);
//        redisTemplate.opsForList().rightPush("queueList",3);
//        redisTemplate.opsForList().rightPush("queueList",4);

//        System.out.println(redisTemplate.opsForList().ri("queueList"));

//        redisTemplate.opsForSet().add("testset",10);
//        redisTemplate.opsForSet().add("testset",3);
//        redisTemplate.opsForSet().add("testset",6);
//        System.out.println(redisTemplate.opsForSet().pop("testset",2));

//        redisTemplate.opsForZSet().add("testZset",10,10);
//        redisTemplate.opsForZSet().add("testZset",8,10);
//        redisTemplate.opsForZSet().add("testZset",10,10);
//        redisTemplate.opsForZSet().add("testZset",6,10);
//        redisTemplate.opsForZSet().add("testZset",7,2);
//        redisTemplate.opsForZSet().remove("testZset",10);
//        System.out.println(redisTemplate.opsForZSet().range("testZset",0,1));

//        redisTemplate.opsForValue().set("value1","ssssssssss");

//        System.out.println(redisTemplate.opsForValue().get("value1"));
    }

}






