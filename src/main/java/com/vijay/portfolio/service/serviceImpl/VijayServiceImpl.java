package com.vijay.portfolio.service.serviceImpl;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vijay.portfolio.model.Experience;
import com.vijay.portfolio.model.PropertyConstants;
import com.vijay.portfolio.model.Vijay;
import com.vijay.portfolio.service.VijayService;

@Service
public class VijayServiceImpl implements VijayService{
	
	private final Vijay vijay;
	
	
	private String experiencePath;
	
	
	private final ResourceLoader resourceLoader;
	private PropertyConstants propertyConstants;
	

	public VijayServiceImpl(Vijay vijay, ResourceLoader resourceLoader,PropertyConstants propertyConstants) {
		
		this.vijay = vijay;
		this.resourceLoader = resourceLoader;
		this.propertyConstants = propertyConstants;
	}


	@Override
	public Vijay getVijay() {
		vijay.setExperience(getExperiences());
		return vijay;
	}
	
	public List<Experience> getExperiences() {
		try {
			Resource resource = resourceLoader.getResource(propertyConstants.getBASE_PATH().concat(propertyConstants.getEXPERIENCE_PATH()));
			InputStream is = resource.getInputStream();
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(is, new TypeReference<List<Experience>>() {});
		} catch (Exception e) {
			throw new RuntimeException("Failed to load experience.json", e);
		}
	}

}
