package com.ashish.webservices.assembler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ashish.webservices.domain.pojo.User;

@Service
public class UserAssembler {

	public com.ashish.webservices.domain.User convertDomain(
			com.ashish.webservices.domain.pojo.User userDomain) {
		com.ashish.webservices.domain.User user = new com.ashish.webservices.domain.User();
		user.setUserid(userDomain.getUserid());
		user.setFirstName(userDomain.getFirstName());
		user.setLastName(userDomain.getLastName());
		user.setEmail(userDomain.getEmail());
		user.setComment(userDomain.getComment());
		return user;
	}
	
	public List<com.ashish.webservices.domain.User> convertDomains(
			List<User> userDomains) {
		List<com.ashish.webservices.domain.User> users = new ArrayList<com.ashish.webservices.domain.User>();
		for (com.ashish.webservices.domain.pojo.User userDomain : userDomains) {
			com.ashish.webservices.domain.User user = convertDomain(userDomain);
			users.add(user);
		}
		return users;
	}

	public User convertToEntity(com.ashish.webservices.domain.User userData) {
		User user = new User();
		user.setFirstName(userData.getFirstName());
		user.setLastName(userData.getLastName());
		user.setEmail(userData.getEmail());
		user.setPassword(userData.getPassword());
		user.setComment(userData.getComment());
		return user;
	}

}
