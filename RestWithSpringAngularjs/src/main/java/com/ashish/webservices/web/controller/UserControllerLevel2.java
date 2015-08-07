package com.ashish.webservices.web.controller;

import java.util.List;

import javax.ws.rs.HeaderParam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ashish.webservices.domain.Task;
import com.ashish.webservices.domain.User;
import com.ashish.webservices.service.UserServiceImplLevel2;
import com.ashish.webservices.service.UserServiceLevel2;


@RestController
public class UserControllerLevel2 {
	
	private UserServiceLevel2 userService = new UserServiceImplLevel2();

	@RequestMapping(value = "/level2users", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<User>> getUsers(){
		ResponseEntity<List<User>> users = userService.getUsers();		
		return users;
	}
	
	@RequestMapping(value="/level2users/{userId}", method = RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<User> findUser(@PathVariable int userId){
		ResponseEntity<User> user = userService.findUser(userId);		
		return user;
	}
	
	@RequestMapping(value="/level2authUsers/{userId}", method = RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<User> authenticateUser(@PathVariable int userId, @HeaderParam("authorization") String authString){
		ResponseEntity<User> user = userService.authenticateUser(userId, authString);	
		return user;
	}
	
	@RequestMapping(value="/level2users/{userId}/tasks", method = RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<List<Task>> userTasks(@PathVariable int userId){
		ResponseEntity<List<Task>> tasks = userService.userTasks(userId);	
		return tasks;
	}
	
	@RequestMapping(value="/level2users/{userId}/tasks/{taskId}", method = RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<Task> userTask(@PathVariable int userId, @PathVariable int taskId){		
		ResponseEntity<Task> task = userService.userTask(userId, taskId);	
		return task;
	}
	

	public void setUserService(UserServiceLevel2 userService) {
		this.userService = userService;
	}


}
