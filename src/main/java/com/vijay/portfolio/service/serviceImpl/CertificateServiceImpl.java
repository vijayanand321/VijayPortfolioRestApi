package com.vijay.portfolio.service.serviceImpl;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vijay.portfolio.model.Certificate;
import com.vijay.portfolio.model.PropertyConstants;
import com.vijay.portfolio.service.CertificateService;

@Service
public class CertificateServiceImpl implements CertificateService {

	private final ResourceLoader resourceLoader;
	private PropertyConstants propertyConstants;

	public CertificateServiceImpl(ResourceLoader resourceLoader, PropertyConstants propertyConstants) {
		this.resourceLoader = resourceLoader;
		this.propertyConstants = propertyConstants;
	}

	@Override
	public List<Certificate> getCertificates() {
		try {
			Resource resource = resourceLoader
					.getResource(propertyConstants.getBASE_PATH().concat(propertyConstants.getCERTIFICATE_PATH()));

			ObjectMapper objectMapper = new ObjectMapper();
			TypeReference<List<Certificate>> typeReference = new TypeReference<>() {
			};
			InputStream is = resource.getInputStream();

			List<Certificate> certificates = new LinkedList<>();

			for (Certificate certificate : objectMapper.readValue(is, typeReference)) {
				certificate.setUrl(propertyConstants.getBASE_URL()
						.concat(certificate.getUrl()));
				certificates.add(certificate);
			}
			return certificates;
		} catch (Exception e) {
			throw new RuntimeException("Failed to load certificates.json", e);
		}
	}

}
