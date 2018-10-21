package com.cc.springbootstudy.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("testConf")
public class ForTest implements MyProfile{
	public String getDBConf() {
		return "testDB";
	}
}