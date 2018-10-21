package com.cc.springbootstudy.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
@Configuration
@ConfigurationProperties(prefix="cc.add")
@PropertySource("classpath:my.properties")
public class MyConf {
	
	private String k1;
	
	public String getK1() {
		return k1;
	}
	public void setK1(String k1) {
		this.k1 = k1;
	}
	private String k3;
	private String k4;
	public String getK3() {
		return k3;
	}
	public void setK3(String k3) {
		this.k3 = k3;
	}
	public String getK4() {
		return k4;
	}
	public void setK4(String k4) {
		this.k4 = k4;
	}
	@Override
	public String toString() {
		return "MyConf [k1=" + k1 + ", k3=" + k3 + ", k4=" + k4 + "]";
	}
	
}
