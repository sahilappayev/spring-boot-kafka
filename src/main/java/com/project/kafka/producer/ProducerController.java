package com.project.kafka.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProducerController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping
    public ResponseEntity<String> postMessage(@RequestParam String message) {
        kafkaTemplate.send("first_topic","key_0", message);
        return ResponseEntity.ok().body("Success");
    }

}
