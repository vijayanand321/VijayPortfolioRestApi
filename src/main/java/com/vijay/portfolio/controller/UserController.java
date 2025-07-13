package com.vijay.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.portfolio.model.User;
import com.vijay.portfolio.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
//@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		
		User createdUser = userService.createUser(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
		
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
}
