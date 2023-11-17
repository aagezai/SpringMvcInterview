package com.facebooked.demofacebooked.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaStringProducer {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaStringProducer.class);
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    public void sendMessage(String message){
        LOGGER.info(String.format("Inside of sendMessage of KafkaProducer to send message"));
        kafkaTemplate.send(topicName, message);
       /* Message message1 = MessageBuilder
                .withPayload(message)
                .setHeader(KafkaHeaders.TOPIC,topicName).build();
        kafkaTemplate.send(message1);*/
    }
}