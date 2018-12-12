/**
 * 
 */
package com.fanatics.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fanatics.beans.ReviewCountBean;
import com.fanatics.services.ReviewService;

/**
 * @author PGerringer
 *
 */
@RestController
@RequestMapping("/view")
public class MovieViewController {
	
	@Autowired 
	private ReviewService service;
	
	/**
	 * GET BY review_id method
	 * @param id
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value="/{id}",
					method=RequestMethod.GET, 
					produces=MediaType.APPLICATION_JSON_VALUE)
	public ReviewCountBean getReviewCount(@PathVariable int id) {
		 return service.getReviewCount(id);
	}

}
