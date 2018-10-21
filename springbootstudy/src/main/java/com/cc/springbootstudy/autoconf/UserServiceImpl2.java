package com.cc.springbootstudy.autoconf;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cc.springbootstudy.user.dao.UserDAO;
import com.cc.springbootstudy.user.service.UserService;
import com.cc.springbootstudy.user.vo.UserModel;

@Transactional
public class UserServiceImpl2 implements UserService<UserModel>{
	@Autowired
	private UserDAO dao = null;
	
	@Override
	public String create(UserModel m) {
		System.out.println("now in UserServiceImpl22222222222222");
		return dao.create(m);
	}

	@Override
	public void update(UserModel m) {
		System.out.println("now in UserServiceImpl22222222222222");
		dao.update(m);
	}

	@Override
	public void delete(String uuid) {
		System.out.println("now in UserServiceImpl22222222222222");
		dao.delete(uuid);
	}

	@Override
	public UserModel getByUuid(String uuid) {
		System.out.println("now in UserServiceImpl22222222222222");
		return dao.getByUuid(uuid);
	}

	@Override
	public List<UserModel> getAll() {
//		int a = 5/0;
		System.out.println("now in UserServiceImpl22222222222222");
		return dao.getAll();
	}


}
