package com.fanatics.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.fanatics.beans.Review;
import com.fanatics.beans.User;
import com.fanatics.repository.ReviewRepository;
import com.fanatics.repository.UserRepository;

@Component
public class App {
	
	@Autowired
	private static UserRepository uRepo;
	
	@Autowired
	private static ReviewRepository rRepo;
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ReviewRepository rRepo = (ReviewRepository) context.getBean(ReviewRepository.class);
		UserRepository uRepo = (UserRepository) context.getBean(UserRepository.class);
		
		List<Review> reviews = rRepo.findAll();
		List<User> users = uRepo.findAll();
		
		System.out.println(reviews);
		System.out.println(users);
		

	}

}
