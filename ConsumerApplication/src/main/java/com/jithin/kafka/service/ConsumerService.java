package com.jithin.kafka.service;

import com.jithin.kafka.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerService {


//    @KafkaListener(topics = "jithin-second-topic",groupId = "jithin-group")
//    public void consumeStringMessage(String message){
//        log.info("Consumed message {}",message);
//    }

    @KafkaListener(topics = "jithin-second-topic",groupId = "jithin-group")
    public void consumeCustomObject(Employee employee){
        log.info("Consumed message {}",employee.toString());
    }


}
