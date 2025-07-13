package com.vijay.portfolio.service.serviceImpl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.vijay.portfolio.model.Hero;
import com.vijay.portfolio.model.Image;
import com.vijay.portfolio.repository.ImageRepository;
import com.vijay.portfolio.service.HeroService;
import com.vijay.portfolio.service.ImageService;

public class ImageServiceImpl implements ImageService{

	@Autowired
	private ImageRepository imageRepository;
	
	@Autowired
	private HeroService heroService;
	
	@Override
	public List<Image> addImage(List<MultipartFile> images) throws IOException {
		
		Hero hero= heroService.getHero();
		
		List<Image> imageList =hero.getImages();
		for(MultipartFile file : images) {
			if(!file.isEmpty()) {
			Image image=new Image();
			image.setImageName(file.getOriginalFilename());
			image.setImageType(file.getContentType());
			image.setImageData(file.getBytes());
			imageRepository.save(image);
			imageList.add(image);
			}
		}
		return imageList;
		
	}

}
