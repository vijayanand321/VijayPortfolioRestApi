package com.vijay.portfolio.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	    @Value("${app.api.username}")
	    private String username;

	    @Value("${app.api.password}")
	    private String password;
	
	
	record AuthRecord(String username,  String password) {}

	@GetMapping
	public ResponseEntity<AuthRecord> getAuth(){
		return ResponseEntity.ok(new AuthRecord(username, password));
	}
	
}
