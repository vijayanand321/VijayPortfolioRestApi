package com.vijay.portfolio.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Field for storing image data (as binary or Base64 string)
    @Lob
    private String imageData;

    private String title;

    @Lob  // Use for large text data
    private String text;

    private String view; // e.g., URL to project demo or a number representing views

    private String source; // URL to source code (GitHub, etc.)

    private String techStack; // Comma-separated or JSON string representing technologies

    // Constructors, Getters and Setters
    public Project() {
    }

    public Project(String imageData, String title, String text, String view, String source, String techStack) {
        this.imageData = imageData;
        this.title = title;
        this.text = text;
        this.view = view;
        this.source = source;
        this.techStack = techStack;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageData() {
        return imageData;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTechStack() {
        return techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }
}

