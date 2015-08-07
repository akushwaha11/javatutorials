package com.ashish.webservices.service;

import java.util.ArrayList;
import java.util.List;

import com.ashish.webservices.domain.Task;
import com.ashish.webservices.utility.EntityCollection;

public class TaskManagerServiceImpl implements TaskManagerService{
 
 //private Connection connection;

 public TaskManagerServiceImpl() {
  //connection = DBUtility.getConnection();
 }

 public void addTask(Task task) {
	 /*
  try {
   PreparedStatement preparedStatement = connection
     .prepareStatement("insert into task_list(task_name,task_description,task_priority,task_status,task_archived,task_start_time,task_end_time) values (?, ?, ?,?,?,?,?)");
   System.out.println("Task:"+task.getTaskName());
   preparedStatement.setString(1, task.getTaskName());
   preparedStatement.setString(2, task.getTaskDescription());   
   preparedStatement.setString(3, task.getTaskPriority());
   preparedStatement.setString(4, task.getTaskStatus());
   preparedStatement.setInt(5,0);
   Date dt = new Date();

   SimpleDateFormat sdf = 
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

   String currentTime = sdf.format(dt);
   preparedStatement.setString(6,currentTime);
   preparedStatement.setString(7,currentTime);
   preparedStatement.executeUpdate();

  } catch (SQLException e) {
   e.printStackTrace();
  }*/

	 EntityCollection entityCollection = EntityCollection.getInstance();
	 entityCollection.addTask(task);

 }
 
 public void archiveTask(int taskId) {
	 
  /*try {
   PreparedStatement preparedStatement = connection
     .prepareStatement("update task_list set task_archived=true where task_id=?");
   // Parameters start with 1
   preparedStatement.setInt(1, taskId);
   preparedStatement.executeUpdate();

  } catch (SQLException e) {
   e.printStackTrace();
  }*/
	 EntityCollection entityCollection = EntityCollection.getInstance();
	 entityCollection.changeTaskStatus(taskId, "Archived");
	 
 }
 
 public void updateTask(Task task){
	 
 /* try {
   PreparedStatement preparedStatement = connection
     .prepareStatement("update task_list set task_name=?, task_description=?, task_priority=?,task_status=?" +
       "where task_id=?");
   preparedStatement.setString(1, task.getTaskName());
   preparedStatement.setString(2, task.getTaskDescription());
   
   preparedStatement.setString(3, task.getTaskPriority());
   preparedStatement.setString(4, task.getTaskStatus());
   preparedStatement.setInt(4, task.getTaskId());
   preparedStatement.executeUpdate();

  } catch (SQLException e) {
   e.printStackTrace();
  }*/
	 EntityCollection entityCollection = EntityCollection.getInstance();
	 entityCollection.updateTask(task);
	 
 }
 
 public void changeTaskStatus(int taskId,String status) {
   /*try {
    PreparedStatement preparedStatement = connection
      .prepareStatement("update task_list set task_status=? where task_id=?");
    preparedStatement.setString(1,status);
    preparedStatement.setInt(2, taskId);
    preparedStatement.executeUpdate();

   } catch (SQLException e) {
    e.printStackTrace();
   }*/
	 EntityCollection entityCollection = EntityCollection.getInstance();
	 entityCollection.changeTaskStatus(taskId, status);
  }


 public List<Task> getAllTasks() {

	 List<Task> tasks = new ArrayList<Task>();
	 /* try {
   Statement statement = connection.createStatement();
   ResultSet rs = statement.executeQuery("select * from task_list where task_archived=0");
   while (rs.next()) {
    Task task = new Task();
    task.setTaskId(rs.getInt("task_id"));
    task.setTaskName(rs.getString("task_name"));
    task.setTaskDescription(rs.getString("task_description"));    
    task.setTaskPriority(rs.getString("task_priority"));
    task.setTaskStatus(rs.getString("task_status"));
    tasks.add(task);
   }
  } catch (SQLException e) {
   e.printStackTrace();
  }*/
	 EntityCollection entityCollection = EntityCollection.getInstance();
	 tasks = entityCollection.getTaskList();

	 return tasks;
 }
 
 public Task getTaskById(int taskId) {
	 Task task = new Task();
	 /*try {
   PreparedStatement preparedStatement = connection.
     prepareStatement("select * from task_list where task_id=?");
   preparedStatement.setInt(1, taskId);
   ResultSet rs = preparedStatement.executeQuery();

   if (rs.next()) {
     task.setTaskId(rs.getInt("task_id"));
     task.setTaskName(rs.getString("task_name"));
     task.setTaskDescription(rs.getString("task_description"));    
     task.setTaskPriority(rs.getString("task_priority"));
     task.setTaskStatus(rs.getString("task_status"));
   }
  } catch (SQLException e) {
   e.printStackTrace();
  }*/
	 EntityCollection entityCollection = EntityCollection.getInstance();
	 task = entityCollection.findTask(taskId);
	 return task;
 }
}
