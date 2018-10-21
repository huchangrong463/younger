package com.cc.springbootstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.cc.springbootstudy.conf.SysConf;

@SpringBootApplication
@EnableTransactionManagement

@EnableConfigurationProperties({SysConf.class})

@ServletComponentScan
public class App extends SpringBootServletInitializer{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(App.class);	
	}
	public static void main(String[] args) {
		//负责启动引导应 用程序
		SpringApplication.run(App.class, args);
	}
}
