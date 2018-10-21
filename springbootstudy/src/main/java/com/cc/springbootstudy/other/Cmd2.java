package com.cc.springbootstudy.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.cc.springbootstudy.user.service.UserService;

@Component
@Order(value=1)
public class Cmd2 implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		System.out.println("now in cmd222222222222222222222222");
		
	}

}
