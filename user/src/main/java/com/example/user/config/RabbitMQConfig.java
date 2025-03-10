package com.example.user.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
/*
    // 定义交换机
    @Bean
    public TopicExchange captchaExchange() {
        return new TopicExchange("captcha-exchange");
    }

    // 定义队列
    @Bean
    public Queue captchaQueue() {
        return new Queue("captcha-queue");
    }

    // 绑定队列到交换机
    @Bean
    public Binding binding(Queue captchaQueue, TopicExchange captchaExchange) {
        return BindingBuilder.bind(captchaQueue).to(captchaExchange).with("captchaKey");
    }*/
}
