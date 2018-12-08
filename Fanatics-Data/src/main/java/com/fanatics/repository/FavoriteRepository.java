package com.fanatics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fanatics.beans.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite,Integer>{

	
	
}
