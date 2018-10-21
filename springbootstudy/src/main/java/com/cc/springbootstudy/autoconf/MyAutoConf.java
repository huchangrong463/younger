package com.cc.springbootstudy.autoconf;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cc.springbootstudy.user.service.UserService;

//@Configuration
//@ConditionalOnClass(UserService.class)
public class MyAutoConf {

//	@Bean
//	@ConditionalOnMissingBean(UserService.class)
//	public UserService autoUserService() {
//		System.out.println("now auto userserviceeeeeeeeeeeeeee");
//		return new UserServiceImpl2();
//	}
}
