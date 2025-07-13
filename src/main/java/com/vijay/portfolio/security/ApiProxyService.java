package com.vijay.portfolio.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiProxyService {
	
	@Value("${app.api.username}")
    private String username;

    @Value("${app.api.password}")
    private String password;


	 public String callExternalApi(String url) {
	        HttpHeaders headers = new HttpHeaders();
	        headers.setBasicAuth(username, password);
	        HttpEntity<Void> entity = new HttpEntity<>(headers);
	        RestTemplate restTemplate = new RestTemplate();

	        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
	        return response.getBody();
	    }
}
