package com.vijay.portfolio.controller;

import com.vijay.portfolio.model.FooterProperties;
import com.vijay.portfolio.service.FooterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/footer")
//@CrossOrigin(origins = "http://localhost:3000")
public class FooterController {

    private final FooterService footerService;

    @Autowired
    public FooterController(FooterService footerService) {
        this.footerService = footerService;
    }

    @GetMapping
    public ResponseEntity<FooterProperties> getFooter() {
        FooterProperties data = footerService.getFooter();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateFooter(@RequestBody FooterProperties newProps) {
        footerService.updateFooter(newProps);
        return new ResponseEntity<>("Footer updated successfully!", HttpStatus.OK);
    }
}

