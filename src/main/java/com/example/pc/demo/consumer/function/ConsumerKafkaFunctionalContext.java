package com.example.pc.demo.consumer.function;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.example.pc.demo.consumer.ConsumerKafkaMsg;

@Configuration
public class ConsumerKafkaFunctionalContext {
	
	@Autowired
	ConsumerKafkaMsg consumerKafkaMsg;
	
	@Bean
	public Consumer<Message<List<String>>> kafkaEventNotificationConsumer(){
		return msgFromKafkaReceived -> consumerKafkaMsg.gotMsgFromKafka(msgFromKafkaReceived);
	}
	
	

}
