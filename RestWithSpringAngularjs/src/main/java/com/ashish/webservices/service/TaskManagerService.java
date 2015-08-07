package com.ashish.webservices.service;

import java.util.List;

import com.ashish.webservices.domain.Task;

public interface TaskManagerService {
	
	 public void addTask(Task task);
	 
	 public void archiveTask(int taskId);
	 
	 public void updateTask(Task task);
	 
	 public void changeTaskStatus(int taskId,String status);

	 public List<Task> getAllTasks();
	 
	 public Task getTaskById(int taskId);

}
