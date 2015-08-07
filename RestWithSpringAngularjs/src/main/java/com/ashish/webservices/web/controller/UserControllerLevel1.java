package com.ashish.webservices.web.controller;


import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ashish.webservices.domain.User;
import com.ashish.webservices.service.UserServiceImplLevel1;
import com.ashish.webservices.service.UserServiceLevel1;


@RestController
public class UserControllerLevel1 {
	
	
	private UserServiceLevel1 userService = new UserServiceImplLevel1();
	
	String message = "Welcome to Spring MVC!";
	 
	@RequestMapping("/hello")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		System.out.println("Inside UserController1");
 
		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", message);
		mv.addObject("name", name);
		return mv;
	}
	
	/*@RequestMapping(value="/users", method = RequestMethod.GET,headers="Accept=application/json")
	public ModelAndView getUsers(@RequestParam(value = "name", required = false, defaultValue = "World") String name){
		System.out.println("-------Inside getUsers of UserController1----------");
		ModelAndView view = new ModelAndView("helloworld");
		view.addObject("message", message);
		view.addObject("name", name);
		return view;
	}*/
	
	@RequestMapping(value="/users", method = RequestMethod.GET,headers="Accept=application/json")
	public List<User> getUsers(){
		List<User> users = userService.getUsers();	
		return users;
	}

	public void setUserService(UserServiceLevel1 userService) {
		this.userService = userService;
	}
	

}
