/**
 * 
 */
package com.fanatics.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.fanatics.beans.ReviewBean;
import com.fanatics.beans.ReviewCountBean;
import com.fanatics.models.Review;
import com.fanatics.models.User;
import com.fanatics.repository.MovieViewRepository;
import com.fanatics.repository.ReviewRepository;
import com.fanatics.repository.ReviewRepositoryCustom;
import com.fanatics.repository.UserRepository;


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
	
	@Autowired
	private static MovieViewRepository movieView;
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
	
	public ReviewCountBean getReviewCount(int id) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		movieView = (MovieViewRepository) context.getBean(MovieViewRepository.class);
		return(movieView.getReviewCount(id));
	}
	
	public Review newReview(Review r) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ReviewRepository repo = (ReviewRepository) context.getBean(ReviewRepository.class);
		Review review = repo.save(r);
		return review;
	}
}
