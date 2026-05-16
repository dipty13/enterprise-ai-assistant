package com.example.enterpriseai.document;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String fileName;

    private String contentType;

    private Long projectId;

    private String createdBy;

    private Instant createdAt;

    protected Document() {
    }

    public Document(String title, String fileName, String contentType, Long projectId, String createdBy) {
        this.title = title;
        this.fileName = fileName;
        this.contentType = contentType;
        this.projectId = projectId;
        this.createdBy = createdBy;
        this.createdAt = Instant.now();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getFileName() {
        return fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public Long getProjectId() {
        return projectId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}