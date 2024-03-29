package com.example.pc.demo.consumer;

import java.util.List;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ConsumerKafkaMsg {
	
	public void gotMsgFromKafka(Message<List<String>> msg) {
		List<String> msgList = msg.getPayload();
		msgList.forEach(msg1 -> log.info("Getting msg from Kafka {}", msg1));
	}

}
