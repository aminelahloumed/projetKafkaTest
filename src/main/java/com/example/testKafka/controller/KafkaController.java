package com.example.testKafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/send")
    public String sendMsgToKafka(@RequestParam("msg") String message) {
        kafkaTemplate.send("topicName", message);
        return "Message sent to Kafka: " + message;
    }
}