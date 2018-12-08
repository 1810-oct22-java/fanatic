package com.fanatics.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fanatics.beans.User;

@Service("userService")
public class UserService {

	static ArrayList<User> Users = new ArrayList<User>();
	static {
		Users.add(new User("UserA", "passA", "FirstNameA", "LastNameA", 1, "biographyA"));
		Users.add(new User("UserB", "passB", "FirstNameB", "LastNameB", 2, "biographyB"));
	}

	/**
	 * 
	 */
	public UserService() {}

	public List<User> getAll(){
		return Users;
	}
	
	public User getById(int id) {
		return Users.stream().filter(t -> t.getId()==id).findFirst()
				.orElse(null);
	}
}
