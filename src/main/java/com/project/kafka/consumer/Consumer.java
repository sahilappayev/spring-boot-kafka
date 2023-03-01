package com.project.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Consumer {

    @KafkaListener(topics = "first_topic", groupId = "first_group", properties = {"auto.offset.reset:earliest"})
    public void consumer(String message) {
        log.info("Message from Kafka Consumer first_group : {}", message);
    }

    @KafkaListener(topics = "first_topic", groupId = "second_group", properties = {"auto.offset.reset:earliest"})
    public void consumer2(String message) {
        log.info("Message from Kafka Consumer second_group: {}", message);
    }


}
