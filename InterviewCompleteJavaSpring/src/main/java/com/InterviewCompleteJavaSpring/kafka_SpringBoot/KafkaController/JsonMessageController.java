package com.InterviewCompleteJavaSpring.kafka_SpringBoot.KafkaController;

/*


import com.facebooked.demofacebooked.pojo.Employee;
import com.facebooked.demofacebooked.service.kafkaService.JsonKafkaConsumer;
import com.facebooked.demofacebooked.service.kafkaService.JsonKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafkaJson")
public class JsonMessageController {

    private JsonKafkaProducer kafkaProducerJson;
    @Autowired
    private JsonKafkaConsumer jsonKafkaConsumer;

    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducerJson = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody Employee employee){
        kafkaProducerJson.sendMessage(employee);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }
    @GetMapping("/consumed")
    public ResponseEntity<Employee> get(){

        Employee employee =jsonKafkaConsumer.getConsumed();


        return new ResponseEntity<>(employee, HttpStatus.ACCEPTED);
    }
}*/
//................. simple step highlight
/*
private static final String STRING_TOPIC_NAME = "dahlakTechno_StringKafka";
private static final String JSON_TOPIC_NAME = "dahlakTechno_jsonKafka";

// Creating a topic for string messages
@Bean
public NewTopic stringKafkaTopic() {
        return TopicBuilder.name(STRING_TOPIC_NAME).build();
        }

// Creating a topic for JSON messages
@Bean
public NewTopic jsonKafkaTopic() {
        return TopicBuilder.name(JSON_TOPIC_NAME).build();
        }

// Kafka listener for receiving string messages
@KafkaListener(topics = STRING_TOPIC_NAME, groupId = "string-group")
public void listenToStringMessages(String message) {
        System.out.println("Received string message: " + message);
        }

// Kafka listener for receiving JSON messages
@KafkaListener(topics = JSON_TOPIC_NAME, groupId = "json-group")
public void listenToJsonMessages(String message) {
        System.out.println("Received JSON message: " + message);
        }*/
