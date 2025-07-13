package com.vijay.portfolio.service;

import java.util.List;

import com.vijay.portfolio.model.Project;

public interface ProjectService {
    Project addProject(Project project);
    void deleteProject(Long id);
    Project updateProject(Long id, Project updatedProject);
    List<Project> getAllProjects();
    Project getProjectById(Long id);
    List<Project> findByTitle(String title); // Method to find projects by title
}
