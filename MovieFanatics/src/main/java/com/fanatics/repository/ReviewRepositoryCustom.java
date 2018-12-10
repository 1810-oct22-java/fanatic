package com.fanatics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fanatics.beans.ReviewBean;

@Repository
public interface ReviewRepositoryCustom  extends JpaRepository<ReviewBean, Integer> {

	@Query("select r.review_id, u.user_name, u.join_date, r.review_date, "
			+ "		r.rating, r.review, a2.source_id as already_reviewed,  "
			+ "		sum(a.thumbs_up) as UP, count(*)-sum(a.thumbs_up) as DOWN"
			+ "from reviews r"
			+ "join users u on r.user_id = u.user_id "
			+ "left join approvals a on a.review_id = r.review_id"
			+ "left join approvals a2 on a2.source_id = :id "
			+ "		and a2.review_id = r.review_id "
			+ "where r.review_expire_date > current_date "
			+ "group by r.review_id, u.user_name, u.join_date, r.review_date, "
			+ "		r.rating, r.review, a2.source_id "
			+ "order by r.review_date desc")
	public List<ReviewBean> findAll(@Param("id") Integer id);
}
