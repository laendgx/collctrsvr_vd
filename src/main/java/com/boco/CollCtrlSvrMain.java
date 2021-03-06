package com.boco;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Timer;
import java.util.TimerTask;


@EnableScheduling
@SpringBootApplication
public class CollCtrlSvrMain {
    /**
     * springboot的main函数
     */
    public static void main(String[] args) {
        SpringApplication.run(CollCtrlSvrMain.class, args);
    }

    /**
     * 消息转换器使用了RabbitMQ自带的Jackson2JsonMessageConverter转换器，用于消息队列JSON类型的传输转换
     */
    @Bean
    public MessageConverter jsonMessageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
