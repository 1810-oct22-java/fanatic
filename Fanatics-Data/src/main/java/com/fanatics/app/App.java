package com.fanatics.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.fanatics.beans.Approval;
import com.fanatics.beans.Favorite;
import com.fanatics.beans.Review;
import com.fanatics.beans.User;
import com.fanatics.repository.ApprovalRepository;
import com.fanatics.repository.FavoriteRepository;
import com.fanatics.repository.ReviewRepository;
import com.fanatics.repository.UserRepository;

@Component
public class App {
	
	@Autowired
	private static UserRepository uRepo;
	
	@Autowired
	private static ReviewRepository rRepo;
	
	@Autowired
	private static ApprovalRepository aRepo;
	
	@Autowired
	private static FavoriteRepository fRepo;
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ReviewRepository rRepo = (ReviewRepository) context.getBean(ReviewRepository.class);
		UserRepository uRepo = (UserRepository) context.getBean(UserRepository.class);
		ApprovalRepository aRepo = (ApprovalRepository) context.getBean(ApprovalRepository.class);
		FavoriteRepository fRepo = (FavoriteRepository) context.getBean(FavoriteRepository.class);
		
		List<Approval> approvals = aRepo.findByReviewId(2);
		
		Review r = rRepo.findUserReviewByMovie(1, 399360);
		System.out.println(r);
		

	}

}
