package com.ashish.webservices.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ashish.webservices.domain.Employee;
import com.ashish.webservices.domain.Task;
import com.ashish.webservices.domain.User;



public class EntityCollection {
	//http://www.programming-free.com/2014/03/spring-mvc-40-restful-web-service-json.html
	
	private static HashMap<Integer, User> users;
	//private static int counter;
	private static EntityCollection instance;
	private static HashMap<Long, Employee> employees;
	private static HashMap<Integer, Task> tasks;
	
	private EntityCollection(){				
		users = new HashMap<Integer, User>();
		User user = new User(1, "one","John", "Smith", "john@in.com");
	    addUser(user);
	    user = new User(2, "two", "John2", "Smith", "john2@in.com");
	    addUser(user);
	    user = new User(3, "three", "John3", "Smith", "john3@in.com");
	    addUser(user);
	    user = new User(4, "four", "David", "Brown", "david2@in.com");
	    addUser(user);
	    
	    
	    	    
	    //--- Add employees
	    employees = new HashMap<Long, Employee>();
	    Employee employee = new Employee(new Long(1), "John", "Smith", "Street 4","Newyork", "New Jersey", "0001");
	    employees.put(employee.getId(), employee);
	    
	    employee = new Employee(new Long(2), "David", "Smith", "Street 5","Eagan", "Mineapolis", "00101");
	    employees.put(employee.getId(), employee);
	    
	    List<Task> userTasks = new ArrayList<Task>();
	    //--- Add Tasks
	    tasks = new HashMap<Integer, Task>();
	    Task task = new Task(501, "LLP Meeting", "Daily LLP meeting with team", "HIGH", "NEW");
	    tasks.put(task.getTaskId(), task);
	    userTasks.add(task);
	    
	    task = new Task(502, "Client Meeting", "Clien status meeting", "LOW", "ACTIVE");
	    tasks.put(task.getTaskId(), task);
	    userTasks.add(task);
	    
	    task = new Task(503, "Client Discussion", "Clien discussion on new requirements", "MEDIUM", "COMPLETED");
	    tasks.put(task.getTaskId(), task);
	    userTasks.add(task);
	    
	    user = new User(5, "five", "Mak", "Joel", "mjoel@in.com");
	    user.setTasks(userTasks);
	    addUser(user);
	    
	    
	   // counter = 5;
	}

	public static EntityCollection getInstance(){
		if (instance == null){
			instance = new EntityCollection();
		}
		return instance;
	}
	
	public HashMap<Integer, User> getUsers() {
		return users;
	}
	
	public void addUser(User user){		
		this.users.put(user.getUserid(), user);		
	}
	
	public User deleteUser(Integer userId){
		User deleted = this.users.remove(userId);
		return deleted;
	}
	
	public List<User> getUsersList(){
		List<User> allUsers = new ArrayList<User>(users.values());
		return allUsers;
	}
	
	public User findUser(Integer userId){
		return users.get(userId);
	}
	
	//--- Employee methods ---
	public void addEmployee(Employee employee){
		this.employees.put(employee.getId(), employee);
	}
	
	public List<Employee> getEmployeesList(){
		List<Employee> allEmployees = new ArrayList<Employee>(employees.values());
		return allEmployees;
	}
	
	public Employee findEmployee(Long id){
		return employees.get(id);
	}
	
	public Employee deleteEmployee(Long id){
		return employees.remove(id);
	}
	
	public void updateEmployee(Employee employee){
		employees.put(employee.getId(), employee);
	}
	
	//--- Task methods ---
	public void addTask(Task task){
		this.tasks.put(task.getTaskId(), task);
	}

	public List<Task> getTaskList(){
		List<Task> allTasks = new ArrayList<Task>(tasks.values());
		return allTasks;
	}

	public Task findTask(Integer id){
		return tasks.get(id);
	}

	public Task deleteTask(Integer id){
		return tasks.remove(id);
	}

	public void updateTask(Task task){
		tasks.put(task.getTaskId(), task);
	}
	
	public void changeTaskStatus(Integer taskid, String taskStatus){
		Task task = tasks.get(taskid);
		task.setTaskStatus(taskStatus);
	}
}
