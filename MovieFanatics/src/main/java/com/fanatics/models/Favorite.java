package com.fanatics.models;

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
	private int user_id;
	@Column(nullable = false, name = "MOVIE_ID")
	private int movie_id;
	
	public Favorite() {}

	public Favorite(int id, int user_id, int movie_id) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.movie_id = movie_id;
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

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	@Override
	public String toString() {
		return "Favorite [id=" + id + ", user_id=" + user_id + ", movie_id=" + movie_id + "]";
	}

}
