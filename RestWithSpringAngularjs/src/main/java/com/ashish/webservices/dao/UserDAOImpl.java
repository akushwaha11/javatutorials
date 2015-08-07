package com.ashish.webservices.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ashish.webservices.domain.pojo.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
    private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<User> getUsers() throws HibernateException {
		return this.sessionFactory.getCurrentSession().createQuery("from User")
				.list();
	}

	public void addUser(User user) throws HibernateException {
		this.sessionFactory.getCurrentSession().save(user);
	}

	public void deleteUser(Integer userId) {
		User user = (User) sessionFactory.getCurrentSession().load(User.class,
				userId);
		if (null != user) {
			this.sessionFactory.getCurrentSession().delete(user);
		}
	}

	public List<User> getUsersList() {
		return null;
	}

	public User findUser(Integer userId) {
		return (User) this.sessionFactory.getCurrentSession().byId(
				userId.toString());
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
