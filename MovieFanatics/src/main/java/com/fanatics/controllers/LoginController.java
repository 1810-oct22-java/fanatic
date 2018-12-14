package com.fanatics.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fanatics.models.User;
import com.fanatics.services.UserService;
import com.fanatics.util.Log;

@RestController
@RequestMapping("/login")
public class LoginController {
    
	@Autowired
	static Logger log = Log.getInstance(ReviewController.class);
    
    @Autowired
    private static UserService uService;

    @CrossOrigin
    @RequestMapping(value="/{username}/{password}",
                    method=RequestMethod.GET, 
                    produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> findById(@PathVariable String username, @PathVariable String password) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		uService = (UserService) context.getBean(UserService.class);
		User u = uService.getByUsername(username);
		log.debug(u);
		u = uService.validateUser(u, password);
		
		if(u == null) {
			//return not found status
			return new ResponseEntity<User>(HttpStatus.I_AM_A_TEAPOT);
		}
		else {
			//return ok status
			return new ResponseEntity<User>(u, HttpStatus.OK);
		}
	}
    
}
