package com.fanatics.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fanatics.models.User;
import com.fanatics.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
	@Autowired
	private UserService service;

	/**
	 * returns results from a GET method
	 * 
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAll() {
		return service.getAll();
	}

	/**
	 * GET BY User_id method
	 * @param id
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value="/{id}",
					method=RequestMethod.GET, 
					produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> findById(@PathVariable int id) {
		User User = service.getById(id);
			
		if(User == null) {
			//return not found status
			return new ResponseEntity<User>(HttpStatus.I_AM_A_TEAPOT);
		}
		else {
			//return ok status
			return new ResponseEntity<User>(User, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/new",
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createNewUser(@RequestBody User user) {
		user = service.newUser(user);
		if(user == null) {
			return new ResponseEntity<User>(HttpStatus.CONFLICT);
		}
		else {
			return new ResponseEntity<User>(user, HttpStatus.CREATED);
		}
	}
}
