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
@Entity //registers class as entity in DB
@Table(name="APPROVALS")//allows further configuration of Table in DB
public class Approval {
    
    private static final long serialVersionUID = 1L;
    
    @Id //necessary for Hibernate to identify objects
    @Column(name="APPROVAL_ID")
    @SequenceGenerator(name="APP_SEQ_GEN", sequenceName="APP_SEQ")
    @GeneratedValue(generator="APP_SEQ_GEN", strategy=GenerationType.SEQUENCE)
    private int id;
    
    @Column(nullable=false, name="REVIEW_ID")
    private int reviewId;
    @Column(nullable=false, name="THUMBS_UP")
    private int thumb;
    @Column(nullable=false, name="SOURCE_ID")
    private int sourceId;

    public Approval () {}

	public Approval(int reviewId, int thumb, int sourceId) {
		super();
		this.reviewId = reviewId;
		this.thumb = thumb;
		this.sourceId = sourceId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getThumb() {
		return thumb;
	}

	public void setThumb(int thumb) {
		this.thumb = thumb;
	}

	public int getSourceId() {
		return sourceId;
	}

	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Approval [id=" + id + ", review_id=" + reviewId + ", thumb=" + thumb + ", source_id=" + sourceId
				+ "]";
	}
    
	
	
}
