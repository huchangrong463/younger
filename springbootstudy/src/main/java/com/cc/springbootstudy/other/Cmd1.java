package com.cc.springbootstudy.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.cc.springbootstudy.user.service.UserService;

@Component
@Order(value=2)
public class Cmd1 implements CommandLineRunner{

	@Autowired
	private UserService us;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("now in cmd1111111111111111");
		
//		System.out.println("user list==="+us.getAll());
	}

}
