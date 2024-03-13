package com.example.RabbitMQ.listeners;

import com.example.RabbitMQ.entities.CallerPerson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class CallerPersonListener {
    /*Kuyruktan sürekli mesajları dinleyecek, alacak, işleyecek*/

    @RabbitListener(queues = "rabbit-queue")//mesajı bu kuyruktan dinleyecek
    public void handleMessage(CallerPerson callerPerson){

        System.out.println("call recieved.");
        System.out.println(callerPerson.toString());// aldığı her mesajı ekrana yazacak
    }
}
