/**
 * 
 */
package com.fanatics.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fanatics.beans.Review;

/**
 * @author PGerringer
 *
 */
@Service("reviewService")
public class ReviewService {
	static ArrayList<Review> reviews = new ArrayList<Review>();
	static {
		reviews.add(new Review(1, 1, 3));
		reviews.add(new Review(2, 1, 5));
	}

	/**
	 * 
	 */
	public ReviewService() {
		// TODO Auto-generated constructor stub
	}

	public List<Review> getAll(){
		return reviews;
	}
	
	public Review getById(int id) {
		return reviews.stream().filter(t -> t.getReview_id()==id).findFirst()
				.orElse(null);
	}
}
