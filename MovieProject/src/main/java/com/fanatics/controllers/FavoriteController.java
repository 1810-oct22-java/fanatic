package com.fanatics.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.fanatics.service.FavoriteService;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {
	
	@Autowired
	private FavoriteService service;

	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Favorite> findAll() {
		return service.getAll();
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}",
					method=RequestMethod.GET, 
					produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Favorite>> findById(@PathVariable int id) {
		List<Favorite> favorites = service.getByUserId(id);
		
		if(favorites == null) {
			//return not found status
			return new ResponseEntity<List<Favorite>>(HttpStatus.I_AM_A_TEAPOT);
		}
		else {
			//return ok status
			return new ResponseEntity<List<Favorite>>(favorites, HttpStatus.OK);
		}
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Favorite> addFavorite(@RequestBody Favorite f) {
		service.newFavorite(f);
		
		if(f == null) {
			return new ResponseEntity<Favorite>(HttpStatus.CONFLICT);
		}
		else {
			return new ResponseEntity<Favorite>(f, HttpStatus.CREATED);
		}
	}
	

	
}
