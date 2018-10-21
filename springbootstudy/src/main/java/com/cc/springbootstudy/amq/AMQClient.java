package com.cc.springbootstudy.amq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class AMQClient {
	@JmsListener(destination="myQueue",containerFactory="jmsListerQueue")
	public void receiveQueue(String text) {
		System.out.println("now in receiveQueue  , msg==="+text);
	}
	
	@JmsListener(destination="myTopic",containerFactory="jmsListerTopic")
	public void receiveTopic1(String text) {
		System.out.println("now in receiveTopic1111111  , msg==="+text);
	}
	@JmsListener(destination="myTopic",containerFactory="jmsListerTopic")
	public void receiveTopic2(String text) {
		System.out.println("now in receiveTopic2222222222  , msg==="+text);
	}
}
