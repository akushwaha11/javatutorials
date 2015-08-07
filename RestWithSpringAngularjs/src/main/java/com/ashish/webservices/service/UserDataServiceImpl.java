package com.ashish.webservices.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ashish.webservices.assembler.UserAssembler;
import com.ashish.webservices.dao.UserDAO;
import com.ashish.webservices.domain.User;

@Service
public class UserDataServiceImpl implements UserDataService {

	@Autowired
	private UserDAO userDao;
	@Autowired
	private UserAssembler userAssembler;

	@Transactional
	public List<User> getUsers() throws HibernateException {
		List<User> users = null;
		List<com.ashish.webservices.domain.pojo.User> userDomains = userDao
				.getUsers();
		if (userDomains != null && userDomains.size() > 0) {
			users = userAssembler.convertDomains(userDomains);
		}

		return users;
	}

	@Transactional
	public void addUser(User user) throws HibernateException {
		// TODO Auto-generated method stub
		com.ashish.webservices.domain.pojo.User userEntity = userAssembler
				.convertToEntity(user);
		userDao.addUser(userEntity);
	}

	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub

	}

	public List<User> getUsersList() {
		// TODO Auto-generated method stub
		return null;
	}

	public User findUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	public void setUserAssembler(UserAssembler userAssembler) {
		this.userAssembler = userAssembler;
	}

}
