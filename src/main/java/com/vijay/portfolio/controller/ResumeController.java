package com.vijay.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.portfolio.model.ResumeModel;

@RestController
@RequestMapping("/resume")
//@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "Content-Disposition")
public class ResumeController {

	@Autowired
	private ResumeModel resumeModel;

	private final ResourceLoader resourceLoader;

	public ResumeController(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	@GetMapping
	public ResponseEntity<Resource> downloadResume() {
		try {
			String fullPath = resumeModel.getPath();

			//Resource resource = new ClassPathResource(fullPath);//this is only for classpath resource

			 Resource resource=resourceLoader.getResource(fullPath);

			// Setting the content type and headers for file download
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + resumeModel.getDownloadName());
			// httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/pdf");
			httpHeaders.setContentType(MediaType.APPLICATION_PDF);

			// return ResponseEntity.ok().headers(httpHeaders).body(resource);
			return new ResponseEntity<Resource>(resource, httpHeaders, HttpStatus.OK);

		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

}
