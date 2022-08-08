package com.example.springboot_demo.rabbitmq.two;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitSend {
    @Autowired
    RabbitTemplate amqpTemplate;

    public void TestOne(String msg) {
        amqpTemplate.convertAndSend("TestOne","222", "TestOne"+msg);
    }

    public void TestTwo(JSONObject jsonObject) {
        amqpTemplate.convertAndSend("topicExchange","topic.one", jsonObject);
    }

    public void TestThree(JSONObject jsonObject) {
        amqpTemplate.convertAndSend("topicExchange","topic.two", jsonObject);
    }
}
