package com.fanatics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fanatics.models.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite,Integer>{

	
	
}
