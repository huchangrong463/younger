package com.cc.springbootstudy.amq;

import javax.jms.Queue;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class AMQProducer {
	@Autowired
	private JmsMessagingTemplate jt;
	@Autowired
	private Queue queue;
	
	@Autowired
	private Topic topic;
	
	public void send(String msg) {
		//
		jt.convertAndSend(queue, msg);
		
		jt.convertAndSend(topic, "the topic msg==="+msg);
	}
}
