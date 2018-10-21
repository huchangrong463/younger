package com.cc.springbootstudy.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("devConf")
public class Dev implements MyProfile {
	public String getDBConf() {
		return "devDB";
	}
}

