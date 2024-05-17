package com.example.pc.demo.producer;

import org.springframework.beans.factory.annotation.Autowired;

//import java.util.List;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Sinks;

@Component
public class ProducerKafkaMsg {
	
	@Autowired
	Sinks.Many<Message<String>> kafkaProducerSinks;

	public String sendMsgToKafka(String msg) {
		
		Message<String> sendMsg = MessageBuilder.withPayload(msg).build();
		kafkaProducerSinks.emitNext(sendMsg, Sinks.EmitFailureHandler.FAIL_FAST);
		return "msgSentToKafka";
	}

}
