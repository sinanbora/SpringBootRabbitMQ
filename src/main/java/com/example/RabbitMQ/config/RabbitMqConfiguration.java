package com.example.RabbitMQ.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Queue;

@Configuration
@EnableScheduling
public class RabbitMqConfiguration {

    @Autowired
    private RabbitTemplate rabbitTemplate;//rabit kuyruğuna erişim için kullanacağız

    @Value("${sr.rabbit.queue.name}")
    private String queueName;
    @Value("${sr.rabbit.routing.name}")
    private String routingName;
    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;

    @Bean
    public Queue queue(){
        return new Queue(queueName,true);
    }
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(exchangeName);
    }
    //Constructor injection
    @Bean
    public Binding bindig(final Queue queue, final DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with(routingName);
    }

}
