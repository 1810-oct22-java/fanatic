/**
 * 
 */
package com.fanatics.beans;

import java.sql.Date;

import org.springframework.stereotype.Component;

/**
 * @author PGerringer
 *
 */
@Component
public class Review {
	private int review_id;
	private int user_id;
	private int movie_id;
	private String review;
	private int rating;
	private int approval_id;
	private Date review_date;
	private Date expire_date;
	
	public Review() {
	}
	
	public Review(int review_id) {
		super();
		this.review_id = review_id;
	}
	
	public int getReview_id() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
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

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getApproval_id() {
		return approval_id;
	}

	public void setApproval_id(int approval_id) {
		this.approval_id = approval_id;
	}

	public Date getReview_date() {
		return review_date;
	}

	public void setReview_date(Date review_date) {
		this.review_date = review_date;
	}

	public Date getExpire_date() {
		return expire_date;
	}

	public void setExpire_date(Date expire_date) {
		this.expire_date = expire_date;
	}

	@Override
	public String toString() {
		return "Review [review_id=" + review_id + ", user_id=" + user_id + ", movie_id=" + movie_id + ", review="
				+ review + ", rating=" + rating + ", approval_id=" + approval_id + ", review_date=" + review_date
				+ ", expire_date=" + expire_date + "]";
	}
}
