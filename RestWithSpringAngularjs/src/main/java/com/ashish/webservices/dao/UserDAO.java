package com.ashish.webservices.dao;

import java.util.List;

import org.hibernate.HibernateException;

import com.ashish.webservices.domain.pojo.User;

public interface UserDAO {

	public List<User> getUsers() throws HibernateException;

	public void addUser(User user) throws HibernateException;

	public void deleteUser(Integer userId);

	public List<User> getUsersList();

	public User findUser(Integer userId);

}
