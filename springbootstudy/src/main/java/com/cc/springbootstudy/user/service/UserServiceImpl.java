package com.cc.springbootstudy.user.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.cc.springbootstudy.user.dao.UserDAO;
import com.cc.springbootstudy.user.vo.UserModel;

@Service
@Transactional
public class UserServiceImpl implements UserService<UserModel>{
	@Autowired
	private RedisTemplate rt;
	
	@Autowired
	private UserDAO dao = null;
	
	@Override
	public String create(UserModel m) {
		
		rt.boundValueOps(m.getUuid()).set(m);
		
		return dao.create(m);
	}

	@Override
	public void update(UserModel m) {
		rt.boundValueOps(m.getUuid()).set(m);
		
		dao.update(m);
	}

	@Override
	public void delete(String uuid) {
		rt.delete(uuid);
		
		dao.delete(uuid);
	}

	@Override
	public UserModel getByUuid(String uuid) {
		//1:先从缓存中获取
		Object obj = rt.opsForValue().get(uuid);
		System.out.println("now from redis obj===="+obj);
		UserModel um = null;
		//2:如果缓存中没有,
		if(obj==null) {
			//2.1才访问数据库
			um = dao.getByUuid(uuid);
			//2.2同时把数据放入到缓存中
			rt.boundValueOps(um.getUuid()).set(um);
		}else {
			//3:缓存有的话,直接转换成需要的对象
			um = (UserModel)obj;
			System.out.println("now from  reids  um========="+um);
		}
		
		return um;
	}

	@Override
	public List<UserModel> getAll() {
		
		return dao.getAll();
	}


}
