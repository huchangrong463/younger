package com.cc.springbootstudy.user.dao;

import java.util.List;

import com.cc.springbootstudy.user.vo.UserModel;

public interface UserDAO<M extends UserModel> {
	public String create(M m);
	public void update(M m);
	public void delete(String uuid);
	public M getByUuid(String uuid);
	public List<M> getAll();
}

