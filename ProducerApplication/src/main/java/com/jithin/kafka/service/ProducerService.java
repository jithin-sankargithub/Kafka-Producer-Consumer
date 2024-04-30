package com.jithin.kafka.service;

import com.jithin.kafka.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class ProducerService {


    private final KafkaTemplate<String,Object> kafkaTemplate;

    public ProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produceStringMessage(String message){
        log.info("Producer sending message {}",message);
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("jithin-second-topic", message);
        future.whenComplete((result,ex)->{
           if(ex == null){
               System.out.println("Producer triggered message: "+message+" into the offset: "+result.getRecordMetadata().offset());
           } else{
               System.out.println("Failed to send message: "+ex.getMessage());
           }
        });
    }

    public void produceCustomObject(Employee employee){
        log.info("Producer sending object {}",employee.toString());
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("jithin-second-topic", employee);
        future.whenComplete((result,ex)->{
            if(ex == null){
                System.out.println("Producer triggered message: "+employee.toString()+" into the offset: "+result.getRecordMetadata().offset());
            } else{
                System.out.println("Failed to send message: "+ex.getMessage());
            }
        });
    }
}
