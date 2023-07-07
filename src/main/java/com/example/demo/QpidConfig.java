//package com.example.demo;
//
//import org.apache.qpid.jms.JmsConnectionFactory;
//import org.springframework.amqp.core.AmqpAdmin;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitAdmin;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class QpidConfig {
//
//    @Value("${qpid.username}")
//    private String username;
//
//    @Value("${qpid.password}")
//    private String password;
//
//    @Value("${qpid.url}")
//    private String url;
//
//    @Bean
//    public JmsConnectionFactory jmsConnectionFactory() {
//        JmsConnectionFactory factory = new JmsConnectionFactory();
//        factory.setUsername(username);
//        factory.setPassword(password);
//        factory.setRemoteURI(url);
//        return factory;
//    }
//
//    @Bean
//    public CachingConnectionFactory cachingConnectionFactory(JmsConnectionFactory jmsConnectionFactory) {
//        CachingConnectionFactory factory = new CachingConnectionFactory(String.valueOf(jmsConnectionFactory));
//        return factory;
//    }
//
//    @Bean
//    public RabbitTemplate rabbitTemplate(CachingConnectionFactory cachingConnectionFactory) {
//        RabbitTemplate rabbitTemplate = new RabbitTemplate(cachingConnectionFactory);
//        return rabbitTemplate;
//    }
//
//    @Bean
//    public AmqpAdmin amqpAdmin(CachingConnectionFactory cachingConnectionFactory) {
//        return new RabbitAdmin(cachingConnectionFactory);
//    }
//
//    @Bean
//    public Queue queue() {
//        return new Queue("your_queue_name");
//    }
//}
