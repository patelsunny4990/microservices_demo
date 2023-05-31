package com.kafka.springbootkafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

	@KafkaListener(topics="wikimedia_changes",groupId ="myGroup")
	public void consume(String message)
	{
		System.out.println("consuming message " + message);
	}
	
}
