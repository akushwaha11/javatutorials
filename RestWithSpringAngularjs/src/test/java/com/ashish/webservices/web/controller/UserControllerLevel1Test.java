package com.ashish.webservices.web.controller;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

import com.ashish.webservices.domain.User;
import com.ashish.webservices.service.UserServiceImplLevel1;
import com.ashish.webservices.service.UserServiceLevel1;

public class UserControllerLevel1Test {
	
	private static final String NAME = "Ashish"; 
	
	private UserControllerLevel1 level1Controller;
	@Mock
	private UserServiceLevel1 userService;
	
	@Before
	public void init(){
		level1Controller = new UserControllerLevel1();
		userService = new UserServiceImplLevel1();
		MockitoAnnotations.initMocks(this);
		level1Controller.setUserService(userService);
		
		List<User> users = new ArrayList<User>();
		User user = new User(1, "one","John", "Smith", "john@in.com");
	    users.add(user);
	    user = new User(2, "two", "John2", "Smith", "john2@in.com");
	    users.add(user);
	    user = new User(3, "three", "John3", "Smith", "john3@in.com");
	    users.add(user);	    
	    
		Mockito.when(userService.getUsers()).thenReturn(users);
	}
	
	@Test
	public void testShowMessage(){
		String name = "Ashish";
		ModelAndView mv = level1Controller.showMessage(name);
		Assert.assertEquals(NAME, mv.getModel().get("name"));
	}
	
	@Test
	public void testFindUser(){
		List<User> users = level1Controller.getUsers();
		Assert.assertNotNull(users);
		Assert.assertEquals(3, users.size());
	}

}
