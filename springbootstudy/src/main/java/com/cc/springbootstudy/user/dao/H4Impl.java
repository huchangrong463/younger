package com.cc.springbootstudy.user.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cc.springbootstudy.user.vo.UserModel;

@Repository
public class H4Impl implements UserDAO<UserModel>{
	@Autowired
	private SessionFactory sf = null;
	
	/**
	 * 获取当前H4要使用的session
	 * @return
	 */
	public Session getH4Session() {
		Session s = null;
		
		try {
			s = sf.getCurrentSession();
		}catch(Exception err) {
			s = sf.openSession();
		}
		return s;
	}
	
	@Override
	public String create(UserModel m) {
		return (String)this.getH4Session().save(m);
	}

	@Override
	public void update(UserModel m) {
		this.getH4Session().update(m);
	}

	@Override
	public void delete(String uuid) {
		String hql = "delete from UserModel o where o.uuid=:uuid ";
		Query q = this.getH4Session().createQuery(hql);
		q.setString("uuid", uuid);
		q.executeUpdate();
	}

	@Override
	public UserModel getByUuid(String uuid) {
		return this.getH4Session().get(UserModel.class, uuid);
	}

	@Override
	public List<UserModel> getAll() {
		String hql = "select o from UserModel o ";
		return this.getH4Session().createQuery(hql).list();
	}

}
