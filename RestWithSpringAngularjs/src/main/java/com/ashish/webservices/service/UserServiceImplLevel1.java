package com.ashish.webservices.service;

import java.util.List;

import com.ashish.webservices.domain.User;
import com.ashish.webservices.service.UserServiceLevel1;
import com.ashish.webservices.utility.EntityCollection;

//@Service("userService1")
public class UserServiceImplLevel1 implements UserServiceLevel1 {

	public List<User> getUsers() {
		EntityCollection entityCollection = EntityCollection.getInstance();
		List<User> users = entityCollection.getUsersList();
		return users;
	}

	public List<User> addUser(User user) {
		return null;
	}

	public User findUser(int userId) {
		EntityCollection entityCollection = EntityCollection.getInstance();
		User user = entityCollection.findUser(userId);
		return user;
	}

	public List<User> deleteUser(int userId) {
		EntityCollection entityCollection = EntityCollection.getInstance();
		User user = entityCollection.deleteUser(userId);
		List<User> users = entityCollection.getUsersList();
		return users;
	}

}
