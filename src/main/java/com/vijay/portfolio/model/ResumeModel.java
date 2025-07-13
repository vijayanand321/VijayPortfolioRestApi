package com.vijay.portfolio.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ResumeModel {

	
	private PropertyConstants propertyConstants;
	
	private String path;
	
	@Value("${resume.download.name}")
	private String downloadName;
	
	

	public ResumeModel(PropertyConstants argPropertyConstants) {
		this.propertyConstants=argPropertyConstants;
		this.path=propertyConstants.getBASE_PATH()+propertyConstants.getRESUME_PATH();
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDownloadName() {
		return downloadName;
	}

	public void setDownloadName(String downloadName) {
		this.downloadName = downloadName;
	}

}
