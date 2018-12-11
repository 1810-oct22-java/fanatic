package com.fanatics.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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

	@OneToOne(fetch = FetchType.LAZY)
	private int user_id;
	
	@Column(nullable = false, name = "MOVIE_ID")
	private int movieId;
	
	public Favorite() {}

	public Favorite(int user_id, int movieId) {
		super();
		this.user_id = user_id;
		this.movieId = movieId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	@Override
	public String toString() {
		return "Favorite [id=" + id + ", user_id=" + user_id + ", movie_id=" + movieId + "]";
	}

}
