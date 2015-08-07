package com.ashish.webservices.domain.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;

	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;

	@Column(name = "LAST_NAME", nullable = true)
	private String lastName; 

	@Column(name = "EMAIL", nullable = true)
	private String email;

	@Column(name = "USER_PASSWORD", nullable = true)
	private String password;

	@Column(name = "COMMENTS", nullable = true)
	private String comment;

	// private List<Task> tasks;
	
	
	public User(){
		
	}
	
	public User(int userId, String password, String firstName, String lastName, String email){
		this();
		this.userid = userId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "User [userid=" + userid + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email="
				+ email + "\n link:" + "]";
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * public List<Task> getTasks() { return tasks; }
	 * 
	 * public void setTasks(List<Task> tasks) { this.tasks = tasks; }
	 */
	

}
