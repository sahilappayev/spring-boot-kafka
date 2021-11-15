package com.project.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Consumer {

    @KafkaListener(topics = "first_topic", groupId = "first_group")
    public void consumer(String message) {
        log.info("Message from Kafka: {}", message);
    }


}
