package com.cc.springbootstudy.conf;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cc.springbootstudy.shiro.MyShiroRealm;

@Configuration
public class ShiroConf {
	@Bean
	public SecurityManager securityManger() {
		DefaultWebSecurityManager dsm = new DefaultWebSecurityManager();
		
		dsm.setRealm(myShiroRealm());
		
		return dsm;
	}
	@Bean
	public MyShiroRealm myShiroRealm() {
		return new MyShiroRealm();
	}
	
	@Bean
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean sf = new ShiroFilterFactoryBean();

		sf.setSecurityManager(securityManager);
		
		Map<String,String> filterDefinitionMap = new LinkedHashMap<String,String>();
		
		filterDefinitionMap.put("/logout", "logout");
		
		filterDefinitionMap.put("/user/**", "authc");
		
		sf.setLoginUrl("/toLogin");
		sf.setSuccessUrl("/user/toList");
		
		sf.setFilterChainDefinitionMap(filterDefinitionMap);
		
		return sf;
	}
	
	
	
}
