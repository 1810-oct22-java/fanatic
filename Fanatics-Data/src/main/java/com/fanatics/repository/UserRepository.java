package com.fanatics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fanatics.beans.User;

@Repository
public interface UserRepository extends JpaRepository <User,Integer>{
	
	public User findByUsernameLikeIgnoreCase(String username);
	
	public User findByEmail(String email);

}