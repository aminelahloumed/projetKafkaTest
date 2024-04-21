package com.example.testKafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "topicName", groupId = "group_id")
    public void listen(String message) {
        System.out.println("==>Received message in group 'group_id': " + message);
    }
    
    
    @KafkaListener(topics = "topicName", groupId = "group_id2")
    public void listen2(String message2) {
        System.out.println("Received message in group 'group_id group2': " + message2);
    }
}