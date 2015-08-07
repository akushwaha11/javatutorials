package com.ashish.webservices.utility.convertor;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.HashCodeBuilder;

import com.ashish.webservices.domain.Task;

public class TestUser {

	private int age = 29;
	private String name = "mkyong";
	private List<String> messages = new ArrayList<String>();
	private List<Task> tasks;

	public TestUser() {
		messages.add("msg 1");
		messages.add("msg 2");
		messages.add("msg 3");

		tasks = new ArrayList<Task>();
		Task task = new Task(1001, "Task1", "Test Task1", "Low", "New");
		tasks.add(task);

		task = new Task(1002, "Task2", "Test Task2", "Medium", "Assigned");
		tasks.add(task);

		task = new Task(1003, "Task3", "Test Task3", "High", "New");
		tasks.add(task);

	}

	// getter and setter methods

	@Override
	public String toString() {
		return "User [age=" + age + ", name=" + name + ", " + "messages="
				+ messages + "]";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public int hashCode() {
		int i = HashCodeBuilder.reflectionHashCode("Targe");
		return i;
	}

}
