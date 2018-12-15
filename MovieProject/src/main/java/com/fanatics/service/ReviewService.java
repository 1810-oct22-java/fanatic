package com.fanatics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.fanatics.models.Review;
import com.fanatics.repository.ReviewRepository;

@Service("reviewService")
public class ReviewService {
	
	@Autowired
	ReviewRepository repo;
	//static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	//static ReviewRepository repo = (ReviewRepository) context.getBean(ReviewRepository.class);
	
	public ReviewService() {
		// TODO Auto-generated constructor stub
	}

	public List<Review> getAll(){
		return repo.findAll();
	}
	
	public Review getById(int id) {
		return repo.findOne(id);
	}
	
	public List<Review> getByUserId(int userId) {
		return repo.findByUserId(userId);
	}
	
	public List<Review> getByMovieId(int movieId) {
		return repo.findByMovieId(movieId);
	}
	
	public Review newReview(Review r) {
		Review review = repo.save(r);
		return review;
	}
}
