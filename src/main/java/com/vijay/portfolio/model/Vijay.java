package com.vijay.portfolio.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Vijay {

	@Value("${vijay.name}")
	private String name;

	@Value("${vijay.role}")
	private String role;

	@Value("${abot.intro}")
	private String intro;
	
	@Value("${about.skills}")
	private String skills;
	
	private List<Experience> experience=new ArrayList<>();

	@Value("${about.data}")
	private String aboutData;

	@Value("${about.start.date}")
	private String startDate;

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getAboutData() {
		LocalDate startDate=LocalDate.parse(getStartDate());
		Period experience = Period.between(startDate, LocalDate.now());
		//double totalYears= experience.getYears() + (experience.getMonths());
		String formattedYears = String.valueOf(experience.getYears()+"."+experience.getMonths());
		//String formattedYears = String.format("%.1f", totalYears);
		return aboutData.replace("#years", formattedYears);
	}

	public void setAboutData(String aboutData) {
		this.aboutData = aboutData;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getName() {
		return name;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public List<Experience> getExperience() {
		return experience;
	}

	public void setExperience(List<Experience> experience) {
		this.experience = experience;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
