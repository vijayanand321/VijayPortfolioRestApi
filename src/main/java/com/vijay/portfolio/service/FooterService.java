package com.vijay.portfolio.service;

import com.vijay.portfolio.model.FooterProperties;

public interface FooterService {

	FooterProperties getFooter();
	
	void updateFooter(FooterProperties footerProperties);
	
}
