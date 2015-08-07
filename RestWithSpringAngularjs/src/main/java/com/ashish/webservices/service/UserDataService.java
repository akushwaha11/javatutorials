package com.ashish.webservices.service;

import java.util.List;

import org.hibernate.HibernateException;

import com.ashish.webservices.domain.User;

public interface UserDataService {

	public List<User> getUsers() throws HibernateException;

	public void addUser(User user) throws HibernateException;

	public void deleteUser(Integer userId);

	public List<User> getUsersList();

	public User findUser(Integer userId);

}
