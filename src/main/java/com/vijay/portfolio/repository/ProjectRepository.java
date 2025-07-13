package com.vijay.portfolio.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vijay.portfolio.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
	
	List<Project> findByTitle(String title);
}

