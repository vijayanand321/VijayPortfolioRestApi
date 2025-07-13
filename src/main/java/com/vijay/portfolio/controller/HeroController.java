package com.vijay.portfolio.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vijay.portfolio.model.Hero;
import com.vijay.portfolio.service.HeroService;

@RestController
@RequestMapping("/hero")
//@CrossOrigin(origins = "http://localhost:3000")
public class HeroController {

    @Autowired
    private HeroService heroService;

    /**
     * Get the Hero data
     * @return Hero record if exists, or 404 if not found.
     */
    @GetMapping
    public ResponseEntity<Hero> getHero() {
        try {
            Hero hero = heroService.getHero();
            return ResponseEntity.ok(hero);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Add a new Hero. Deletes the existing Hero if one already exists.
     * @param hero Hero data
     * @param imageFiles List of image files to associate with the Hero
     * @return Saved Hero data
     */
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Hero> addHero(@RequestPart(value = "heros") Hero hero,
                                        @RequestPart(value = "images") List<MultipartFile> imageFiles,
                                        @RequestHeader("Content-Type") String contentType) {
    	
    	System.out.println(contentType);
        try {
            Hero savedHero = heroService.addHero(hero, imageFiles);
            return ResponseEntity.ok(savedHero);
        } catch (IOException e) {
        	System.out.println(e);
            return ResponseEntity.status(500).body(null);
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(null);
        }
    }

    /**
     * Update the existing Hero record.
     * @param heroId ID of the Hero to update
     * @param hero Hero data to update
     * @param images Optional images to add
     * @return Updated Hero data
     */
    @PutMapping("/{heroId}")
    public ResponseEntity<Hero> updateHero(@PathVariable Integer heroId,
                                           @RequestPart("hero") Hero hero,
                                           @RequestPart(value = "images", required = false) List<MultipartFile> images) {
        try {
            Hero updatedHero = heroService.updateHero(heroId, hero, images);
            return ResponseEntity.ok(updatedHero);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Delete the existing Hero record.
     * @return Success or failure response
     */
    @DeleteMapping("/{heroId}")
    public ResponseEntity<Void> deleteHero(@PathVariable Integer heroId) {
        boolean isDeleted = heroService.deleteHero(heroId);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(400).build();
    }
}
