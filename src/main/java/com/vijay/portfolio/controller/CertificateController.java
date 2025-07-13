package com.vijay.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.portfolio.model.Certificate;
import com.vijay.portfolio.service.CertificateService;

@RestController
@RequestMapping("/certificates")
public class CertificateController {

	@Autowired
	private CertificateService certificateService;
	
	@GetMapping
	public ResponseEntity<List<Certificate>> getCertificates(){
		List<Certificate> certificates = certificateService.getCertificates();
		return ResponseEntity.ok(certificates);
	}
	
}
