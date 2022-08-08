package com.example.springboot_demo.rabbitmq.two;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class RabbitMQAck {
    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "testack.one"), exchange = @Exchange(value = "ackexchange", type = ExchangeTypes.TOPIC), key = "testack.one"))
    @RabbitHandler
    public void TestAckOne(String mag, Channel channel, Message message) throws IOException {
        try {
            System.out.println("TestACK.ONE" + mag);
//            int i = 1 / 0;
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("*****************：：" + message.getMessageProperties().getDeliveryTag() + ":" + mag);
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);

        }

    }
}
