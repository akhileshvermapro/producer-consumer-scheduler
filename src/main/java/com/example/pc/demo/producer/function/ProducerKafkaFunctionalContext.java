package com.example.pc.demo.producer.function;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Configuration
@Slf4j
public class ProducerKafkaFunctionalContext {
	
	@Bean
	public Sinks.Many<Message<String>> kafkaProducerSink(){
		return Sinks.many().unicast().onBackpressureBuffer();
	}
	
	//functional context
	@Bean
	public Supplier<Flux<Message<String>>> kafkaEventNotificationProducer(@Qualifier("kafkaProducerSink") Sinks.Many<Message<String>> kafkaProducerSink){
		return () -> kafkaProducerSink.asFlux()
				.doOnNext(m -> log.info("Sending msg to Kafka {}", m))
				.doOnError(t -> log.error("Error occured while sending msg to Kafka {}", t));
	}

}
