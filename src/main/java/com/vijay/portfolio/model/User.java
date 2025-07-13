package com.vijay.portfolio.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


@Entity
@Table(name = "users")
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_id;
	
	@Column(unique = true, nullable = false)
	private String username;
	
	
	@NotBlank(message = "email is required")
	@Email(message = "email should be valid")
	@Column(unique = true, nullable = false)
	private String email;
	
	private String message;
	
	@NotBlank(message = "mobile number is required")
	@Pattern(regexp = "^\\d{10}$", message = "Mobile number must be exactly 10 digits")
	@Column(name = "mobile_number")
	private String mobileNumber;
	
	@Column(updatable = false)
	private LocalDateTime created_date;
	
	
	public User() {
		super();
	}


	public User(Integer user_id, String username, String email, String message, String mobile_number,
			LocalDateTime created_date) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.email = email;
		this.message = message;
		this.mobileNumber = mobile_number;
		this.created_date = created_date;
	}


	public Integer getUser_id() {
		return user_id;
	}


	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobile_number) {
		this.mobileNumber = mobile_number;
	}


	public LocalDateTime getCreated_date() {
		return created_date;
	}


	@PrePersist
	public void setCreated_date() {
		this.created_date = LocalDateTime.now();
	}


	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", email=" + email + ", message=" + message
				+ ", mobile_number=" + mobileNumber + ", created_date=" + created_date + "]";
	}
	
	
}
