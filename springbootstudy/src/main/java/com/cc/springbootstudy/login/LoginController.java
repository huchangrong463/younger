package com.cc.springbootstudy.login;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "/login";
	}
	@RequestMapping("/login")
	public String login(HttpServletRequest req,Model m) {
		String userId = req.getParameter("userId");
		String pwd = req.getParameter("pwd");
		
		Subject cs = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken(userId,pwd);
		
		cs.login(token);
		
		
//		if(!userId.startsWith("cc")) {
//			m.addAttribute("errorMsg","用户名或密码不正确");
//			return "forward:/toLogin";
//		}
		
//		req.getSession().setAttribute("NowLogin", "login");
		
		return "forward:/user/toList";
	}
	
}
