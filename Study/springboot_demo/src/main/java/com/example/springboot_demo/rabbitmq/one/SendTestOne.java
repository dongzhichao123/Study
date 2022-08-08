package com.example.springboot_demo.rabbitmq.one;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendTestOne {
    @Autowired
    private AmqpTemplate amqpTemplate;

    //direct 方式，交换机名称随便填写，但是不能填写direct，会造成两次消费
    public void senfDriect(String direct, Message msg) {
        amqpTemplate.send(direct, msg);
    }
}
