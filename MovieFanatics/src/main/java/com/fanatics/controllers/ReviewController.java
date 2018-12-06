/**
 * 
 */
package com.fanatics.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fanatics.beans.Review;
import com.fanatics.services.ReviewService;

/**
 * @author PGerringer
 *
 */
@RestController
public class ReviewController {
	@Autowired
	private ReviewService service;

	/**
	 * 
	 */
	public ReviewController() {
		
	}
	
	/**
	 * returns results from a GET method
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Review> getAll(){
		return service.getAll();
	} 

}
