package com.vijay.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.portfolio.model.Vijay;
import com.vijay.portfolio.service.VijayService;

@RestController
@RequestMapping("/vijay")
public class VijayController {
	
	@Autowired
	VijayService vijayService;

	@GetMapping
	public ResponseEntity<Vijay> getVijay() {
		Vijay vijay = vijayService.getVijay();
		vijay.setAboutData(vijay.getAboutData());
		return new ResponseEntity<>(vijay, HttpStatus.OK);
	}
	
}
