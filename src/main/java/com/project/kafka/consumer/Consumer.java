package com.project.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Consumer {

    @KafkaListener(topics = "first_topic", groupId = "first_group",
            properties = {ConsumerConfig.AUTO_OFFSET_RESET_CONFIG + ":earliest",
                    ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG + ":false"})
    public void consumer(@Payload String message,
                         @Header(KafkaHeaders.ACKNOWLEDGMENT) Acknowledgment acknowledgment,
                         @Header(KafkaHeaders.OFFSET) long offset,
                         @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partitionId ) {
        acknowledgment.acknowledge();
        log.info("Message from Kafka Message: {}, partitionId : {}, offset: {}, acknowledgment: {}",
                message, partitionId, offset, acknowledgment);
    }

    @KafkaListener(topics = "first_topic", groupId = "second_group",
            properties = {ConsumerConfig.AUTO_OFFSET_RESET_CONFIG + ":earliest",
                    ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG + ":false"})
    public void consumer2(@Payload String message,
                          @Header(KafkaHeaders.ACKNOWLEDGMENT) Acknowledgment acknowledgment,
                          @Header(KafkaHeaders.OFFSET) long offset,
                          @Header(KafkaHeaders.CONSUMER) KafkaConsumer<String, Object> consumer) {
        log.info("Message from Kafka Message: {} Consumer : {}, partition: , offset: {}, acknowledgment: {}",
                message, consumer, offset, acknowledgment);
    }


}
