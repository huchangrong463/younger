package com.cc.springbootstudy.conf;

import java.net.InetAddress;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ESConf {

	@Bean
	public TransportClient client() {
		TransportClient client = null;
		Settings settings = Settings.settingsBuilder()
				// 指定集群名称
				//.put("cluster.name", "my-application")
				// 探测集群中机器状态
				.put("client.transport.sniff", false).build();
		try {
			client = TransportClient.builder().settings(settings).build()
					.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.1.108"), 9300));
		} catch (Exception err) {
			err.printStackTrace();
		}

		return client;
	}
}
