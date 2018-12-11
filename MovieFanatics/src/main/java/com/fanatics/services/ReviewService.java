/**
 * 
 */
package com.fanatics.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.fanatics.beans.ReviewBean;
import com.fanatics.controllers.ReviewController;
import com.fanatics.models.Review;
import com.fanatics.repository.ReviewRepository;
import com.fanatics.repository.ReviewRepositoryCustom;
import com.fanatics.util.Log;

/**
 * @author PGerringer
 *
 */
@Service("reviewService")
public class ReviewService {
	static Logger log = Log.getInstance(ReviewController.class);
	
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
		log.debug("ReviewService.getView()");
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		custom = (ReviewRepositoryCustom) context.getBean(ReviewRepositoryCustom.class);
		return custom.findAll(new Integer(id), movie_id);
	}
}
