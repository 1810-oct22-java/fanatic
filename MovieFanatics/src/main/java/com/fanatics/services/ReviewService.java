/**
 * 
 */
package com.fanatics.services;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.fanatics.beans.RatingCountBean;
import com.fanatics.beans.ReviewBean;
import com.fanatics.models.Review;
import com.fanatics.models.User;
import com.fanatics.repository.ReviewRepository;
import com.fanatics.repository.ReviewRepositoryCustom;
import com.fanatics.repository.UserRepository;
import com.fanatics.util.Tool;

/**
 * @author PGerringer
 *
 */
@Service("reviewService")
public class ReviewService {
	
	@Autowired
	private static ReviewRepository repo;
	
	@Autowired
	private static ReviewRepositoryCustom custom;
	
	/**
	 * 
	 */
	public ReviewService() {
		// TODO Auto-generated constructor stub
	}

	public List<Review> getAll(){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		repo = (ReviewRepository) context.getBean(ReviewRepository.class);
		return repo.findAll();
	}
	
	public Review getById(int id) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		repo = (ReviewRepository) context.getBean(ReviewRepository.class);
		return repo.findOne(id);
	}
	
	public List<ReviewBean> getView(int id, int movie_id) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		custom = (ReviewRepositoryCustom) context.getBean(ReviewRepositoryCustom.class);
		return custom.findAll(new Integer(id), movie_id);
	}
	
	public RatingCountBean getRatingCount(int id) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		custom = (ReviewRepositoryCustom) context.getBean(ReviewRepositoryCustom.class);
		return(custom.getRatingCount(id));
	}
	
	public Review newReview(Review review) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ReviewRepository repo = (ReviewRepository) context.getBean(ReviewRepository.class);
		
		review.setExpire_date(Tool.getTime(Tool.tenYears()));
		review.setReview_date(Tool.getTime(Tool.getCurrentDate()));

		review = repo.save(review);
		
		return review;
	}
}
