package com.fanatics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fanatics.beans.Approval;

@Repository
public interface ApprovalRepository extends JpaRepository <Approval,Integer>{

	public List<Approval> findBySourceId(int id);
	
	public List<Approval> findByReviewId(int id);
	
	@Query("SELECT a FROM Approval a WHERE a.sourceId=?1 AND a.reviewId=?2")
	public Approval findUserApprovalByMovie(int sourceId, int reviewId);
	
}
