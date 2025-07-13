package com.vijay.portfolio.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.portfolio.model.Project;
import com.vijay.portfolio.repository.ProjectRepository;
import com.vijay.portfolio.service.ProjectService;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project addProject(Project project) {
    	
        return projectRepository.save(project);
    }

    @Override
    public void deleteProject(Long id) {
        Optional<Project> project = projectRepository.findById(id);
        if (project.isPresent()) {
            projectRepository.delete(project.get());
        } else {
            throw new IllegalArgumentException("Project not found with ID: " + id);
        }
    }

    @Override
    public Project updateProject(Long id, Project updatedProject) {
        return projectRepository.findById(id)
                .map(project -> {
                    // Update fields only if they are not null
                    if (updatedProject.getTitle() != null) {
                        project.setTitle(updatedProject.getTitle());
                    }
                    if (updatedProject.getText() != null) {
                        project.setText(updatedProject.getText());
                    }
                    if (updatedProject.getTechStack() != null) {
                        project.setTechStack(updatedProject.getTechStack());
                    }
                    if (updatedProject.getImageData() != null) {
                        project.setImageData(updatedProject.getImageData());
                    }
                    return projectRepository.save(project);
                })
                .orElseThrow(() -> new IllegalArgumentException("Project not found with ID: " + id));
    }


    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Project not found with ID: " + id));
    }

    @Override
    public List<Project> findByTitle(String title) {
        return projectRepository.findByTitle(title); 
    }
}
