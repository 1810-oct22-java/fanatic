/**
 * 
 */
package com.fanatics.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.fanatics.beans.ReviewCountBean;

/**
 * @author PGerr
 *
 */
@Repository
public class MovieViewRepository {
	@PersistenceContext
    private EntityManager entityManager;
	
	public ReviewCountBean getReviewCount(Integer movie_id) {
		ReviewCountBean data = (ReviewCountBean) entityManager
        	.createNativeQuery("select count(*) as TOTAL, round(avg(rating),0) as RATING " + 
        						"from reviews where movie_id = :movie_id ")
        	.setParameter("movie_id",  movie_id)
        	.getSingleResult();
		
		System.out.println(data);
		
        return data;
	}
	
	
}
