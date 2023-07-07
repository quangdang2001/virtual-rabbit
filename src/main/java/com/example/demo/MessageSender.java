//package com.example.demo;
//
//import org.springframework.amqp.cor.Queue;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MessageSender {
//
//    private final RabbitTemplate rabbitTemplate;
//    private final Queue queue;
//
//    @Autowired
//    public MessageSender(RabbitTemplate rabbitTemplate, Queue queue) {
//        this.rabbitTemplate = rabbitTemplate;
//        this.queue = queue;
//    }
//
//    public void sendMessage(String message) {
//        rabbitTemplate.convertAndSend(queue.getName(), message);
//    }
//}