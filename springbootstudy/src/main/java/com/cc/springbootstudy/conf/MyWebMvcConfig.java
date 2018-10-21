package com.cc.springbootstudy.conf;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.cc.springbootstudy.mvc.MyInterceptor;

@Configuration
public class MyWebMvcConfig extends WebMvcConfigurerAdapter {
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static2/**").addResourceLocations("classpath:/static2/");
		super.addResourceHandlers(registry);
	}

	public void addInterceptors(InterceptorRegistry registry) {
	  registry.addInterceptor(new MyInterceptor())
	  .addPathPatterns("/**")
	  .excludePathPatterns("/toLogin","/login");
	  super.addInterceptors(registry);
	  }

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("mymessages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}


}
