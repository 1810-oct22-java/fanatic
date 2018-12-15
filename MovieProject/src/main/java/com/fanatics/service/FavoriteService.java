package com.fanatics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.fanatics.models.Favorite;
import com.fanatics.repository.FavoriteRepository;

@Service("favoriteService")
public class FavoriteService {
	/**
	 * 
	 */
	@Autowired
	FavoriteRepository repo;
	//static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	//static FavoriteRepository repo = (FavoriteRepository) context.getBean(FavoriteRepository.class);
	
	public FavoriteService() {
		
	}

	public List<Favorite> getAll() {
		return repo.findAll(); 
	}

	public List<Favorite> getByUserId(int id) {
		List<Favorite> favorites = repo.findByUserId(id);
		return favorites;
	}

	public Favorite newFavorite(Favorite f) {
		Favorite fav = repo.save(f);
		return fav;
	}

}
