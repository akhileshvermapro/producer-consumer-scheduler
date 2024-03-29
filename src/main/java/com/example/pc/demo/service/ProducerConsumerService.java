package com.example.pc.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import com.example.pc.demo.producer.ProducerKafkaMsg;

import reactor.core.publisher.Sinks;

@Service
public class ProducerConsumerService {
	
	@Autowired
	ProducerKafkaMsg producerKafkaMsg;

	public String getKafkaMsg(String msg) {
		return producerKafkaMsg.sendMsgToKafka(msg);
	}

}
