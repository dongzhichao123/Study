package com.example.springboot_demo.rabbitmq.two;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class RabbitReceiver {
    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "TestOne"), exchange = @Exchange(value = "TestOneExchange", type = ExchangeTypes.DIRECT), key = "222"))
    @RabbitHandler
    public void TestOne(String msg) {
        System.out.println("TestOne:" + msg);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "TestTwo"), exchange = @Exchange(value = "TestOneExchange", type = ExchangeTypes.DIRECT), key = "111"))
    @RabbitHandler
    public void TestTwo(String msg) {
        System.out.println("TestTwo:" + msg);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "topic.one", autoDelete = "false"), exchange = @Exchange(value = "topicExchange", type = ExchangeTypes.TOPIC), key = "topic.one"))
    @RabbitHandler
    public void TpoicOne(JSONObject msg) {
        System.out.println("TpoicOne:" + msg.toJSONString());
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "topic.two", autoDelete = "false"), exchange = @Exchange(value = "topicExchange", type = ExchangeTypes.TOPIC), key = "topic.two"))
    @RabbitHandler
    public void TpoicTwo(JSONObject msg) {
        System.out.println("TpoicTwo:" + msg.toJSONString());
    }

}
