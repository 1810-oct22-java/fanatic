/**
 * 
 */
package com.fanatics.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.fanatics.models.Review;
import com.fanatics.models.User;
import com.fanatics.repository.ReviewRepository;
import com.fanatics.repository.UserRepository;

/**
 * @author PGerringer
 *
 */
@Service("reviewService")
public class ReviewService {
	@Autowired
	private static ReviewRepository rRepo;
	/**
	 * 
	 */
	public ReviewService() {
		// TODO Auto-generated constructor stub
	}

	public List<Review> getAll(){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ReviewRepository rRepo = (ReviewRepository) context.getBean(ReviewRepository.class);
		List<Review> reviews = rRepo.findAll();
		
		return reviews;
	}
	
	public Review getById(int id) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ReviewRepository repo = (ReviewRepository) context.getBean(ReviewRepository.class);
		Review review = repo.findOne(id);
		
		return review;
	}
}
