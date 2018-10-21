package com.cc.springbootstudy.conf;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.stereotype.Component;

import com.cc.springbootstudy.servlet.MyFilter;
import com.cc.springbootstudy.servlet.MyListener;
import com.cc.springbootstudy.servlet.MyServlet;

//@Component
public class ServletInit implements ServletContextInitializer{

	@Override
	public void onStartup(ServletContext ctx) throws ServletException {
		
		EnumSet<DispatcherType> types = EnumSet.allOf(DispatcherType.class);
		
		types.add(DispatcherType.REQUEST);
		types.add(DispatcherType.FORWARD);
		
		ctx.addFilter("myF1", new MyFilter()).addMappingForUrlPatterns(types, true, "/*");
		
		ctx.addServlet("myS1", MyServlet.class).addMapping("/myServlet2/*");
		ctx.addListener(new MyListener());
		
		
	}

}
