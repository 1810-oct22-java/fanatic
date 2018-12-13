package com.fanatics.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fanatics.models.Favorite;
import com.fanatics.models.User;
import com.fanatics.repository.FavoriteRepository;
import com.fanatics.services.UserService;
import com.fanatics.util.Log;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {

	@Autowired
	static Logger log = Log.getInstance(ReviewController.class);
	private static FavoriteRepository fRepo;
	
	@CrossOrigin
	@RequestMapping(value="/{id}",
					method=RequestMethod.GET, 
					produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Favorite>> findById(@PathVariable int id) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		fRepo = (FavoriteRepository) context.getBean(FavoriteRepository.class);
		List<Favorite> favorites = fRepo.findByUserId(id);
		log.debug(favorites);
		
		if(favorites == null) {
			//return not found status
			return new ResponseEntity<List<Favorite>>(HttpStatus.I_AM_A_TEAPOT);
		}
		else {
			//return ok status
			return new ResponseEntity<List<Favorite>>(favorites, HttpStatus.OK);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Favorite> addFavorite(@RequestBody Favorite f) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		fRepo = (FavoriteRepository) context.getBean(FavoriteRepository.class);
		fRepo.save(f);
		
		if(f == null) {
			return new ResponseEntity<Favorite>(HttpStatus.CONFLICT);
		}
		else {
			return new ResponseEntity<Favorite>(f, HttpStatus.CREATED);
		}
	}
	

	
}
