/**
 * 
 */
package com.fanatics.services;

import java.util.ArrayList;
import java.util.List;

import com.fanatics.beans.Review;

/**
 * @author PGerringer
 *
 */
public class ReviewService {
	static ArrayList<Review> reviews = new ArrayList<Review>();

	/**
	 * 
	 */
	public ReviewService() {
		// TODO Auto-generated constructor stub
	}

	public List<Review> getAll(){
		return reviews;
	}
}
