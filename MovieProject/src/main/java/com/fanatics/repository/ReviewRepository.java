package com.fanatics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fanatics.models.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

	public List<Review> findByUserId(int user_id);
	
	public List<Review> findByMovieId(int movie_id);
		
}

