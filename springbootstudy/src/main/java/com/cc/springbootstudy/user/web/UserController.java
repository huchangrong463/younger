package com.cc.springbootstudy.user.web;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cc.springbootstudy.user.service.UserService;
import com.cc.springbootstudy.user.vo.UserModel;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService<UserModel> us;
	
	
	@ExceptionHandler(value=Exception.class)
	public ModelAndView resolveErrorView(HttpServletRequest request,
			Exception ex) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("path", request.getRequestURL());
		mv.addObject("ex",ex);
		
		mv.setViewName("/error");
		
		return mv;
	}
	
	@RequestMapping("/toList")
	public String toList(Model m,HttpServletRequest req) {
		List<UserModel> list = us.getAll();
		m.addAttribute("userList",list);
		
		req.getSession().setAttribute("s1", "123<b>中文</b>");
		req.getServletContext().setAttribute("sctx1", "haha哈哈");
		
		m.addAttribute("myNum",12345);
		m.addAttribute("myBool",true);
		
		m.addAttribute("myCal",Calendar.getInstance());
		
		
		return "/user/userList";
	}
	
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "/user/userAdd";
	}
	@RequestMapping("/add")
	public String add(UserModel um) {
		us.create(um);
		return "forward:/user/toList";
	}
	@RequestMapping("/toUpdate")
	public String toUpdate(Model m,@RequestParam("uuid")String uuid) {
		UserModel um = us.getByUuid(uuid);
		m.addAttribute("um",um);
		
		return "/user/userUpdate";
	}
	@RequestMapping("/update")
	public String update(UserModel um) {
		us.update(um);
		return "forward:/user/toList";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("uuid")String uuid) {
		us.delete(uuid);
		return "forward:/user/toList";
	}
	
	
}
