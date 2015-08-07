package com.ashish.webservices.service;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Links;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import sun.misc.BASE64Decoder;

import com.ashish.webservices.domain.Task;
import com.ashish.webservices.domain.User;
import com.ashish.webservices.hateoas.UserLinks;
import com.ashish.webservices.utility.EntityCollection;

public class UserServiceImplLevel2 implements UserServiceLevel2{
	private UserLinks userLinks;
	
	@Inject
	void setUserLinks(UserLinks userLinks) {
		this.userLinks = userLinks;
	}

	public ResponseEntity<List<User>> getUsers() {		
		EntityCollection entityCollection = EntityCollection.getInstance();
		List<User> users = entityCollection.getUsersList();
		ResponseEntity<List<User>> response = new ResponseEntity<List<User>>(users, HttpStatus.OK);
		return response;
	}

	public ResponseEntity<User> findUser(int userId) {
		EntityCollection entityCollection = EntityCollection.getInstance();
		User user = entityCollection.findUser(userId);
		Link userLink = this.userLinks.getSelfLink(user);
		Link taskLink = this.userLinks.getTasksLink(user);
		Links wrapperOfLinks = new Links(userLink, taskLink);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Link", wrapperOfLinks.toString());
		//httpHeaders.setLocation();
		ResponseEntity<User> response = new ResponseEntity<User>(user, HttpStatus.FOUND);
		return response;
	}
	
	public ResponseEntity<User> authenticateUser(int userId, String authString){
		boolean isValidUser = isUserAuthenticated(authString);
		ResponseEntity<User> response = null;
		if(isValidUser){
			response = findUser(userId);
		}
		else{
			response = new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
			
		return response;
	}
	
	private boolean isUserAuthenticated(String authString){
        
        String decodedAuth = "";
        // Header is in the format "Basic 5tyc0uiDat4"
        // We need to extract data before decoding it back to original string
        String[] authParts = authString.split("\\s+");
        String authInfo = authParts[1];
        // Decode the data back to original string
        byte[] bytes = null;
        try {
            bytes = new BASE64Decoder().decodeBuffer(authInfo);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        decodedAuth = new String(bytes);
        System.out.println(decodedAuth);
         
        /**
         * here you include your logic to validate user authentication.
         * it can be using ldap, or token exchange mechanism or your 
         * custom authentication mechanism.
         */
        // your validation code goes here....
         
        return true;
    }

	public ResponseEntity<List<Task>> userTasks(int userId) {
		EntityCollection entityCollection = EntityCollection.getInstance();
		User user = entityCollection.findUser(userId);
		List<Task> tasks = user.getTasks();
		ResponseEntity<List<Task>> response = new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
		return response;
	}

	public ResponseEntity<Task> userTask(int userId, int taskId) {
		ResponseEntity<Task> response = null;
		EntityCollection entityCollection = EntityCollection.getInstance();
		User user = entityCollection.findUser(userId);
		List<Task> tasks = user.getTasks();
		Task task = null;
		if(tasks != null && tasks.size() > 0){
			for(Task userTask : tasks){
				if (userTask.getTaskId() == taskId){
					task = userTask;
					break;
				}
			}
			 response = new ResponseEntity<Task>(task, HttpStatus.OK);
		}
		else{
			response = new ResponseEntity(HttpStatus.FORBIDDEN);
		}	   
		return response;
	}

	
}
