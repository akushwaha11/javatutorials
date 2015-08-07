package com.ashish.webservices.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ashish.webservices.domain.User;
import com.ashish.webservices.service.UserDataService;

@RestController
public class UserController {

	@Autowired
	private UserDataService dataService;

	@RequestMapping(value = "/listDBUsers", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<User>> getDBUsers() {
		ResponseEntity<List<User>> resp = null;
		List<User> users = new ArrayList<User>();
		try {
			users = dataService.getUsers();
			resp = new ResponseEntity<List<User>>(users,
				HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<List<User>>(users, HttpStatus.NOT_FOUND);

		}
		return resp;
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public String addUser(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("email") String email) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		String response = null;
		try {

		dataService.addUser(user);
			response = "{\"message\":\"Post With ngResource: The user firstname: "
				+ user.getFirstName()
				+ ", lastname: "
				+ user.getLastName()
				+ ", email: "
 + user.getEmail() + " - Created " + "\"}";
		} catch (Exception e) {
			response = "{\"message\":\"Post With ngResource: User Name:"
					+ user.getFirstName() + " " + user.getLastName()
					+ "  Failed" + "\"}";
		}
		return response;
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/user/delete", method = RequestMethod.PUT)
	public String deleteUser(@RequestParam("userid") int userid) {
		dataService.deleteUser(userid);
		String response = "{\"message\":\"User with user id : " + userid
				+ " deleted" + "\"}";
		return response;
	}

	@ExceptionHandler(Exception.class)
	    public ResponseEntity<String> errorHandler(Exception exc) {
		return new ResponseEntity(exc.getMessage(), HttpStatus.BAD_REQUEST);
	    }

	public void setDataService(UserDataService dataService) {
		this.dataService = dataService;
	}
}
