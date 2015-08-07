package com.ashish.webservices.service;

import java.util.List;

import com.ashish.webservices.domain.User;

public interface UserServiceLevel1 {
	
	public List<User> getUsers();
	
	public List<User> addUser(User user);
	
	public User findUser(int userId);
	
	public List<User> deleteUser(int userId);

}
