package com.ashish.webservices.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ashish.webservices.domain.Task;
import com.ashish.webservices.domain.User;

public interface UserServiceLevel2 {

	public ResponseEntity<List<User>> getUsers();
	
	public ResponseEntity<User> findUser(int userId);
	
	public ResponseEntity<User> authenticateUser(int userId, String authString);
	
	public ResponseEntity<List<Task>> userTasks(int userId);
	
	public ResponseEntity<Task> userTask(int userId, int taskId);
}
