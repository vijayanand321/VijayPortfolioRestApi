package com.vijay.portfolio.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.vijay.portfolio.model.Image;

public interface ImageService {
	
	List<Image> addImage(List<MultipartFile> images) throws IOException;

}
