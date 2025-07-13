package com.vijay.portfolio.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertyConstants {
	
	@Value("${server.port}")
	private String PORT_NUMBER;
	
	@Value("${base.url}")
	private String BASE_URL;
	
	@Value("${base.path}")
	private String BASE_PATH;
	
	@Value("${resume.file.path}")
	private String RESUME_PATH;
	
	@Value("${images.folder.path}")
	private String IMAGES_PATH;
	
	@Value("${images.url}")
	private String IMAGES_URL;
	
	@Value("${certificate.path}")
	private String CERTIFICATE_PATH;
	
	@Value("${experience.path}")
	private String EXPERIENCE_PATH;
	

	public String getEXPERIENCE_PATH() {
		return EXPERIENCE_PATH;
	}

	public String getPORT_NUMBER() {
		return PORT_NUMBER;
	}

	public String getBASE_URL() {
		return BASE_URL;
	}

	public String getBASE_PATH() {
		return BASE_PATH;
	}

	public String getRESUME_PATH() {
		return RESUME_PATH;
	}

	public String getIMAGES_PATH() {
		return IMAGES_PATH;
	}

	public String getIMAGES_URL() {
		return IMAGES_URL;
	}

	public String getCERTIFICATE_PATH() {
		return CERTIFICATE_PATH;
	}
	
	

}
