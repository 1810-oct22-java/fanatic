package com.fanatics.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.fanatics.models.User;
import com.fanatics.repository.UserRepository;

@Service("userService")
public class UserService {
	/**
	 * 
	 */
	@Autowired
	UserRepository repo;
	//static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	//static UserRepository repo = (UserRepository) context.getBean(UserRepository.class);
	
	public UserService() {
		
	}

	public List<User> getAll() {
		List<User> user = repo.findAll();

		return user;
	}

	public User getById(int id) {
		User user = repo.findOne(id);

		return user;
	}

	public User newUser(User u) {
		System.out.println(u);
		u.setIsAdmin(0);
		u.setIsVerified(0);
		u.setJoinDate(new Timestamp(System.currentTimeMillis()));
		System.out.println(u);
		User user = repo.save(u);
		System.out.println(user);
		return user;
	}
	
	public User getByUsername(String username) {
        User u = repo.findByUsername(username);
        return u;
    }
    
    public User validateUser(User u, String password) {
        if (u.getPassword().equals(password)) {
            return u;
        }
        else {
            return null;
        }
    }

}

