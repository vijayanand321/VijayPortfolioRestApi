package com.vijay.portfolio.model;

import java.util.List;

public class Experience {
	private String company;
	private String role;
	private String startDate;
	private String endDate;
	private List<String> description;
	
	// Getters and Setters
	public String getCompany() { return company; }
	public void setCompany(String company) { this.company = company; }

	public String getRole() { return role; }
	public void setRole(String role) { this.role = role; }

	public String getStartDate() { return startDate; }
	public void setStartDate(String startDate) { this.startDate = startDate; }

	public String getEndDate() { return endDate; }
	public void setEndDate(String endDate) { this.endDate = endDate; }

	public List<String> getDescription() { return description; }
	public void setDescription(List<String> description) { this.description = description; }
}
