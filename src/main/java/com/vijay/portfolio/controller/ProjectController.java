package com.vijay.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vijay.portfolio.model.Project;
import com.vijay.portfolio.service.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/projects")
//@CrossOrigin(origins = "http://localhost:3000")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // Get all projects
    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects); // Return 200 OK with the list of projects
    }

    // Get a project by ID
    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.getProjectById(id));
    }

    // Add a new project
    @PostMapping
    public ResponseEntity<Project> addProject(@RequestBody Project project) {
    	
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.addProject(project)); // Return 201 Created
    }

    // Update a project
    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project updatedProject) {
        return ResponseEntity.ok(projectService.updateProject(id, updatedProject));
    }

    // Delete a project
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.ok().build(); // Return 204 No Content
    }

    // Find projects by title
    @GetMapping("/title/{title}")
    public ResponseEntity<List<Project>> findByTitle(@PathVariable String title) {
        return ResponseEntity.ok(projectService.findByTitle(title));
    }
}

