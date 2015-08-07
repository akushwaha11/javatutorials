package com.ashish.webservices.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import com.ashish.webservices.domain.User;
import com.ashish.webservices.service.UserServiceLevel2;

public class UserControllerLevel2Test {
	
	private static final Integer USERID = 1;
	private UserControllerLevel2 controller = null;
	private UserServiceLevel2 userService = null;
	
	@Before
	public void setup(){
		controller = new UserControllerLevel2();
		userService = Mockito.mock(UserServiceLevel2.class);
		controller.setUserService(userService);
		
		User user = new User(1, "one","John", "Smith", "john@in.com");
		ResponseEntity<User> user1 = new ResponseEntity<User>(user, HttpStatus.OK);		
		Mockito.when(userService.findUser(USERID)).thenReturn(user1);
		
		List<User> users = new ArrayList<User>();		
	    users.add(user);
	    user = new User(2, "two", "John2", "Smith", "john2@in.com");
	    users.add(user);
	    user = new User(3, "three", "John3", "Smith", "john3@in.com");
	    users.add(user);
	    
	    ResponseEntity<List<User>> userList = new ResponseEntity<List<User>>(users, HttpStatus.OK);		    
		Mockito.when(userService.getUsers()).thenReturn(userList);
	}
	
	@Test
	public void testFindUserSuccess(){
		ResponseEntity<User> user = controller.findUser(USERID);
		Assert.notNull(user);
		Mockito.verify(userService).findUser(USERID);		
	}
	
	
	public void testGetUsersSuccess(){
		ResponseEntity<List<User>> users = controller.getUsers();
		Assert.notNull(users);	
		
	}

}
