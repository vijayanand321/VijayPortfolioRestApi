package com.vijay.portfolio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijay.portfolio.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{

	Optional<User> findByemail(String email);
	
	Optional<User> findByusername(String username);
	
	Optional<User> findBymobileNumber(String mobile_number);
	
}
