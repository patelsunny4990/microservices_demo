package com.kafka.springbootkafka.producer;

import org.springframework.kafka.core.KafkaTemplate;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;

public class WikimediaHandler implements EventHandler {

	private KafkaTemplate<String, String> kafkaTemplate;
	private String topic;

	public WikimediaHandler(KafkaTemplate<String, String> kafkaTemplate, String topic) {
		super();
		this.kafkaTemplate = kafkaTemplate;
		this.topic = topic;
	}

	@Override
	public void onOpen() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClosed() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMessage(String event, MessageEvent messageEvent) throws Exception {
		kafkaTemplate.send(topic, messageEvent.getData());

	}

	@Override
	public void onComment(String comment) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void onError(Throwable t) {
		// TODO Auto-generated method stub

	}

}
