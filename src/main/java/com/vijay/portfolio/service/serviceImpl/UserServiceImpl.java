package com.vijay.portfolio.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.portfolio.ExceptionsHandler.UserExceptions.DuplicateResourceException;
import com.vijay.portfolio.ExceptionsHandler.UserExceptions.UserNotFoundException;
import com.vijay.portfolio.model.User;
import com.vijay.portfolio.repository.UserRepository;
import com.vijay.portfolio.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();	
	}

	@Override
	public User createUser(User user) {
		
		if(findByEmail(user.getEmail())) {
			throw new DuplicateResourceException("user already exists with email: "+user.getEmail());
		}else if(findBymobile_number(user.getMobileNumber())) {
			throw new DuplicateResourceException("user already exists with mobile number: "+user.getMobileNumber());
		}else if(findByUserName(user.getUsername())) {
			throw new DuplicateResourceException("user already exists with username: "+user.getUsername());
		}
		
		return userRepository.save(user);
	}

	@Override
	public User getUser(Integer userId) throws Exception {
		Optional<User> user = userRepository.findById(userId);
		
		if(user.isEmpty()) {
			throw new UserNotFoundException("user not found for id: "+userId);
		}
		
		return user.get();
	}

	@Override
	public void deleteUser(Integer userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public boolean findByEmail(String email) {
		return userRepository.findByemail(email).isPresent();
	}
	
	@Override
	public boolean findByUserName(String username) {
		return userRepository.findByusername(username).isPresent();
	}

	@Override
	public boolean findBymobile_number(String mobileNumber) {
		return userRepository.findBymobileNumber(mobileNumber).isPresent();
	}

}
