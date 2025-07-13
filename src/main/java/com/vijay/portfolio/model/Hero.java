package com.vijay.portfolio.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class Hero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer heroId;
	
	@Column(nullable = false)
	private  String name;
	
	@Column(nullable = false)
	private String title;
	
	private String email;
	
	private String password;
	
	@OneToMany(mappedBy = "hero", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Image> images =new ArrayList<>();
	
	@Column(updatable = false)
	private LocalDateTime createdDate;
	
	private LocalDateTime updateDate;

	public Integer getId() {
		return heroId;
	}

	public String getName() {
		return name;
	}

	public String getTitle() {
		return title;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public List<Image> getImages() {
		return images;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setId(Integer id) {
		this.heroId = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdDate = LocalDateTime.now();
		this.updateDate = LocalDateTime.now();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updateDate = LocalDateTime.now();
	}
	
}
