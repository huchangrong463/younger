package com.cc.springbootstudy.conf;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileUploadConf {
	@Bean
	public MultipartConfigElement myFileUpload() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//设置文件大小
		factory.setMaxFileSize("128KB");
		factory.setMaxRequestSize("1MB");
		
		return factory.createMultipartConfig();
	}
}
