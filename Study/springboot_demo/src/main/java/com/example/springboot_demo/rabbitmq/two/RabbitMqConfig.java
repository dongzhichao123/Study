package com.example.springboot_demo.rabbitmq.two;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
@Bean
    public RabbitTemplate createRabbitThemplate(ConnectionFactory connectionFactory){
    RabbitTemplate rabbitTemplate=new RabbitTemplate();
    rabbitTemplate.setConnectionFactory(connectionFactory);
    rabbitTemplate.setMandatory(true);
    rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
        @Override
        public void confirm(CorrelationData correlationData, boolean b, String s) {
            System.out.println("\n确认消息送到交换机(Exchange)结果：");
            System.out.println("相关数据：" + correlationData);
            System.out.println("是否成功：" + b);
            System.out.println("错误原因：" + s);


        }
    });
    rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
        @Override
        public void returnedMessage(Message message, int i, String s, String s1, String s2) {
            System.out.println("\n确认消息送到队列(Queue)结果：");
            System.out.println("发生消息：" +message);
            System.out.println("回应码：" + i);
            System.out.println("回应信息：" +s);
            System.out.println("交换机：" + s1);
            System.out.println("路由键：" +s2);

        }
    });
    return rabbitTemplate;
}
}
