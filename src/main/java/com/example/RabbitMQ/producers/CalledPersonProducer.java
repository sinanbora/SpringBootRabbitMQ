package com.example.RabbitMQ.producers;

import com.example.RabbitMQ.entities.CallerPerson;
import jakarta.annotation.PostConstruct;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class CalledPersonProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate; // rabbit'in connection nesnesini RabbitTemplate üzerinden sunucuya gönderiyoruz

    CallerPerson callerPerson = new CallerPerson();
    //kuyruğa mesaj gönderen kişi
    @Value("${sr.rabbit.routing.name}")
    private String routingName;

    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;

    @PostConstruct
    public void init(){
        /*
        * produce edilecek nesne doğru bir sekilde initialize olduktan sonra message'ı gondersin
        * */
        runSomething();
    }

    @Scheduled(fixedDelay = 5000, initialDelay = 5000)
    private void runSomething() {
        callerPerson.setCallerPersonId(String.valueOf(UUID.randomUUID().toString()));
        callerPerson.setCallerPerson("Sinan");
        callerPerson.setCreatedAt(new Date());
        callerPerson.setMessage("Welcome to RabbitMQ");
        callerPerson.setSeen(false);
        sendToQueue(callerPerson);
    }

    private void sendToQueue(CallerPerson callerPerson) {
        System.out.println("CallerPerson Sent ID: " +callerPerson.getCallerPersonId());
        rabbitTemplate.convertAndSend(exchangeName,routingName,callerPerson); // istediğimiz routing'e mesajı gönderecek
    }


}
