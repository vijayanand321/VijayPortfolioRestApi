package com.vijay.portfolio.service.serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vijay.portfolio.model.Hero;
import com.vijay.portfolio.model.Image;
import com.vijay.portfolio.repository.HeroRepository;
import com.vijay.portfolio.service.HeroService;

@Service
public class HeroServiceImpl implements HeroService{
	
	@Autowired
	private HeroRepository heroRepository;

	@Override
	public Hero addHero(Hero hero, List<MultipartFile> imageFiles) throws IOException {
		
		Hero oldHero =getHero();
		
		if(oldHero!=null) {
			if(!deleteHero(oldHero.getId())) {
				throw new RuntimeException("Hero record cannot be deleted");
			}
		}
		
		if (imageFiles != null && !imageFiles.isEmpty()) {
	        List<Image> images = new ArrayList<>();
	        for (MultipartFile imageFile : imageFiles) {
	            if (!imageFile.isEmpty()) {
	                Image newImage = new Image();
	                newImage.setImageName(imageFile.getOriginalFilename());
	                newImage.setImageType(imageFile.getContentType());
	                newImage.setImageData(imageFile.getBytes());
	                images.add(newImage);
	            }
	        }
	        hero.setImages(images); // Assign images to the hero
	    }
		
		return heroRepository.save(hero);
		
	}

	@Override
	public Hero updateHero(Integer heroId, Hero hero, List<MultipartFile> images) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hero getHero() {
		Optional<Hero> first = heroRepository.findAll().stream().findFirst();
		return first.get();
	}

	@Override
	public boolean deleteHero(Integer integer) {
		
		Hero oldHero = getHero();
		if(oldHero!=null) {
			heroRepository.delete(oldHero);
			return true;
		}
		return false;
	}


		

}
