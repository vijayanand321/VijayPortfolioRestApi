package com.vijay.portfolio.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.portfolio.service.VijayImageService;

@RestController
@RequestMapping("/images")
public class VijayImageController {
	
	@Autowired
	VijayImageService vijayImageService;
	
	@GetMapping
	public ResponseEntity<List<String>> getImageUrls() throws IOException {
		
		List<String> vijayImages = vijayImageService.getVijayImage();
		
		return new ResponseEntity<List<String>>(vijayImages,HttpStatus.OK);
	}
	
	

}
