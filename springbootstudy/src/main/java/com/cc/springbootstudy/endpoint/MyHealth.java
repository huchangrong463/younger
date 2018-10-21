package com.cc.springbootstudy.endpoint;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
@Component
public class MyHealth implements HealthIndicator{

	@Override
	public Health health() {
		
		String str = check();
		if(!"OK".equals(str)) {
			return Health.down()
				.withDetail("cc.msg", "now is downnnnnnnnnn")
				.withDetail("cc.msg222", "now is test")
				.build();
		}
		return Health.up().withDetail("cc.UP", "now is okkkkkkkkkk").build();
	}
	private String check() {
		//真正进行健康检查的逻辑
		return "OK";
	}

}