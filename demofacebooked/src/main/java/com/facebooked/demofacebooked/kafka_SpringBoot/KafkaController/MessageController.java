package com.facebooked.demofacebooked.kafka_SpringBoot.KafkaController;
/*
import com.facebooked.demofacebooked.service.kafkaService.KafkaStringProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafkaString")
public class MessageController {

    private KafkaStringProducer kafkaStringProducer;

    public MessageController(KafkaStringProducer kafkaStringProducer) {
        this.kafkaStringProducer = kafkaStringProducer;
    }

    // http:localhost:8080/api/v1/kafka/publish?message=hello world
    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        kafkaStringProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic");
    }
}*/
