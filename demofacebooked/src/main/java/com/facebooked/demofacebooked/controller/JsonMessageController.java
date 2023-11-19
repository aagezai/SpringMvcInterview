package com.facebooked.demofacebooked.controller;



import com.facebooked.demofacebooked.pojo.Employee;
import com.facebooked.demofacebooked.service.JsonKafkaConsumer;
import com.facebooked.demofacebooked.service.JsonKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
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
}