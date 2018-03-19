package com.example.websocketdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessageSendingOperations;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ITopic;
import com.hazelcast.core.Message;
import com.hazelcast.core.MessageListener;

@Configuration
public class ChatConfig {
	@Autowired
    private SimpMessageSendingOperations messagingTemplate;
	
	@Bean
	HazelcastInstance create() {
		Config config = new Config();
		HazelcastInstance instance = Hazelcast.newHazelcastInstance(config);
		ITopic<Object> topic = instance.getTopic("msg-topic");
		topic.addMessageListener(new MessageListener<Object>() {
			
			@Override
			public void onMessage(Message<Object> message) {
				messagingTemplate.convertAndSend("/topic/public", message.getMessageObject());
			}
		});
		return instance;
	}

}
