package com.fanatics.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity // registers class as entity in DB
@Table(name = "FAVORITES")
public class Favorite {
	@Id // necessary for Hibernate to identify objects
	@Column(name = "FAVORITE_ID")
	@SequenceGenerator(name = "FAV_SEQ_GEN", sequenceName = "FAV_SEQ")
	@GeneratedValue(generator = "FAV_SEQ_GEN", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(nullable = false, name = "USER_ID")
	private int user;
	
	@Column(nullable = false, name = "MOVIE_ID")
	private int movie_id;
	
	public Favorite() {}

	public Favorite(int id, int user, int movie_id) {
		super();
		this.id = id;
		this.user = user;
		this.movie_id = movie_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	/**
	 * @return the user
	 */
	public int getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(int user) {
		this.user = user;
	}
}
