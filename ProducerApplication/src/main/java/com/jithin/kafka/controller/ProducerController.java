package com.jithin.kafka.controller;

import com.jithin.kafka.dto.Employee;
import com.jithin.kafka.service.ProducerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    private final ProducerService producerService;

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping("publishString/{message}")
    public ResponseEntity<String> publishStringMessage(@PathVariable String message){
        try{
            producerService.produceStringMessage(message);
            return ResponseEntity.ok("Message send to consumers");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("publishObject")
    public ResponseEntity<String> publishObject(@RequestBody Employee employee){
        try{
            producerService.produceCustomObject(employee);
            return ResponseEntity.ok("Object send to consumers");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
