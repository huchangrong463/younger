package com.cc.springbootstudy.conf;


import javax.jms.Queue;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

@Configuration
public class AMQConf {
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("myQueue");
	}
	@Bean
	public Topic topic() {
		return new ActiveMQTopic("myTopic");
	}
	
	@Bean
	public JmsListenerContainerFactory<?> jmsListerQueue(ActiveMQConnectionFactory cf){
		DefaultJmsListenerContainerFactory jf = new DefaultJmsListenerContainerFactory();
		jf.setConnectionFactory(cf);
		return jf;
	}
	@Bean
	public JmsListenerContainerFactory<?> jmsListerTopic(ActiveMQConnectionFactory cf){
		DefaultJmsListenerContainerFactory jf = new DefaultJmsListenerContainerFactory();
		jf.setPubSubDomain(true);
		jf.setConnectionFactory(cf);
		return jf;
	}
	
	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
		return new ActiveMQConnectionFactory("tcp://192.168.1.108:61616");
	}
}
