package com.cc.springbootstudy.conf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cc.springbootstudy.servlet.MyFilter;
import com.cc.springbootstudy.servlet.MyListener;
import com.cc.springbootstudy.servlet.MyServlet;

//@Configuration
public class ServletConf {

//	@Bean
	public ServletRegistrationBean myServlet1() {
		return new ServletRegistrationBean(new MyServlet(),"/myServlet/*");
	}
	
//	@Bean
	public FilterRegistrationBean myFilger1() {
		FilterRegistrationBean fb = new FilterRegistrationBean();
		fb.setFilter(new MyFilter());
		
		List<String> list = new ArrayList<String>();
		list.add("/*");
		
		fb.setUrlPatterns(list);
		
		return fb;
	}
//	@Bean
	public ServletListenerRegistrationBean myListener1() {
		return new ServletListenerRegistrationBean(new MyListener());
	}
	
	
}
