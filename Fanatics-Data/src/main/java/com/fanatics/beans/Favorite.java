package com.fanatics.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity // registers class as entity in DB
@Table(name = "FAVORITES")
public class Favorite {

	private static final long serialVersionUID = 1L;

	@Id // necessary for Hibernate to identify objects
	@Column(name = "FAVORITE_ID")
	@SequenceGenerator(name = "FAV_SEQ_GEN", sequenceName = "FAV_SEQ")
	@GeneratedValue(generator = "FAV_SEQ_GEN", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(nullable = false, name = "USER_ID")
	private int userId;
	@Column(nullable = false, name = "MOVIE_ID")
	private int movieId;
	
	public Favorite() {}

	public Favorite(int userId, int movieId) {
		super();
		this.userId = userId;
		this.movieId = movieId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUser_id(int userId) {
		this.userId = userId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	@Override
	public String toString() {
		return "Favorite [id=" + id + ", user_id=" + userId + ", movie_id=" + movieId + "]";
	}

}
