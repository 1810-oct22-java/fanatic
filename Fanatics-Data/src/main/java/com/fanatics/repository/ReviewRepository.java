package com.fanatics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fanatics.beans.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>{
	
	public List<Review> findByMovieId(int id);
	
	public List<Review> findByUserId(int id);
	
	@Query("SELECT r FROM Review r WHERE r.userId=?1 AND r.movieId=?2")
	public Review findUserReviewByMovie(int userId, int movieId);

}
