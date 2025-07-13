package com.vijay.portfolio.service.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.vijay.portfolio.model.PropertyConstants;
import com.vijay.portfolio.service.VijayImageService;

@Service
public class VijayImageServiceImpl implements VijayImageService {

	PropertyConstants propertyConstants;

	private final ResourceLoader resourceLoader;

	public VijayImageServiceImpl(ResourceLoader resourceLoader, PropertyConstants propertyConstants) {
		this.resourceLoader = resourceLoader;
		this.propertyConstants = propertyConstants;
	}

	@Override
	public List<String> getVijayImage() throws IOException {
		Resource resource = resourceLoader
				.getResource(propertyConstants.getBASE_PATH() + propertyConstants.getIMAGES_PATH());
		File[] listFiles = null;
		File file2 = resource.getFile();
		if (file2.isDirectory()) {
			listFiles = file2.listFiles();
		}
		List<String> imageUrls = new LinkedList<>();

		if (listFiles != null) {
			for (File file : listFiles) {
				if (file.isFile()) {
					imageUrls.add(propertyConstants.getBASE_URL() 
							+ propertyConstants.getIMAGES_URL() + file.getName());
				}
			}
		}

		return imageUrls;
	}

}
