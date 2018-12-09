package com.fanatics.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity //registers class as entity in DB
@Table(name="REVIEWS")//allows further configuration of Table in DB
public class Review {
    

    private static final long serialVersionUID = 1L;
    
    @Id //necessary for Hibernate to identify objects
    @Column(name="REVIEW_ID")
    @SequenceGenerator(name="REV_SEQ_GEN", sequenceName="REV_SEQ")
    @GeneratedValue(generator="REV_SEQ_GEN", strategy=GenerationType.SEQUENCE)
    private int reviewId;
    
    @Column(nullable=false, unique=true, name="USER_ID")
    private int userId;
    @Column(nullable=false, name="MOVIE_ID")
    private int movieId;
    @Column(nullable=false, name="REVIEW")
    private String review;
    @Column(nullable=false, name="RATING")
    private int rating;
    @Column(nullable=false, name="REVIEW_DATE")
    private Timestamp reviewDate;
    @Column(nullable=false, name="REVIEW_EXPIRE_DATE")
    private Timestamp expireDate;

    public Review() {
    }

    public Review(int userId, int movieId) {
        super();
        this.userId = userId;
        this.movieId = movieId;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
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

    public Timestamp getReviewDate() {
        return reviewDate;
    }

    public void setReview_date(Timestamp reviewDate) {
        this.reviewDate = reviewDate;
    }

    public Timestamp getExpireDate() {
        return expireDate;
    }

    public void setExpire_date(Timestamp expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {
        return "Review [review_id=" + reviewId + ", user_id=" + userId + ", movie_id=" + movieId + ", review="
                + review + ", rating=" + rating +  ", review_date=" + reviewDate
                + ", expire_date=" + expireDate + "]";
    }
}