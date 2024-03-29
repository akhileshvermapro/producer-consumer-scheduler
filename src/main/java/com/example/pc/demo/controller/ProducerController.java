package com.example.pc.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.pc.demo.service.ProducerConsumerService;

@RestController
public class ProducerController {
	
	@Autowired
	ProducerConsumerService producerConsumerService;
	
	@GetMapping("/publish/{msg}")
	public ResponseEntity<String> publishMsg(@PathVariable("msg") String msg){
		ResponseEntity<String> msg1 = ResponseEntity.ok(producerConsumerService.getKafkaMsg(msg));
		return msg1;
	}

}
