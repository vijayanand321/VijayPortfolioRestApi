package com.vijay.portfolio.service;

import java.util.List;

import com.vijay.portfolio.model.User;


public interface UserService {
	
	List<User> getAllUsers();
	
	User createUser(User user);
	
	User getUser(Integer userId) throws Exception;
	
	void deleteUser(Integer userId);
	
	boolean findByEmail(String email);
	
	boolean findByUserName(String username);
	
	boolean findBymobile_number(String mobileNumber);

}
