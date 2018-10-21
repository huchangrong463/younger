package com.cc.springbootstudy.conf;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@Component
public class MyExceptionHandler {
	
//	@ExceptionHandler(value=Exception.class)
//	public ModelAndView resolveErrorView(HttpServletRequest request,
//            HttpStatus status, Map<String, Object> model,Exception ex) {
//		ModelAndView mv = new ModelAndView();
//		
//		mv.addObject("path", request.getRequestURL());
//		mv.addObject("ex",ex);
//		mv.addObject("m",model);
//		
//		mv.setViewName("/error");
//		
//		return mv;
//	}
}
