package com.vijay.portfolio.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Certificate {
    // Private Fields
    private String name;
    private String issuer;
    private String status;
    private List<String> tags; // Using java.util.List for tags
    private String url;

    // Constructor
    public Certificate(String name, String issuer, String status, List<String> tags, String url) {
        this.name = name;
        this.issuer = issuer;
        this.status = status;
        this.tags = tags;
        this.url = url;
    }

    // Default (no-argument) constructor, often useful for frameworks
    public Certificate() {
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getIssuer() {
        return issuer;
    }

    public String getStatus() {
        return status;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getUrl() {
        return url;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Certificate{" +
               "name='" + name + '\'' +
               ", issuer='" + issuer + '\'' +
               ", status='" + status + '\'' +
               ", tags=" + tags +
               ", url='" + url + '\'' +
               '}';
    }
}