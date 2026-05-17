package com.example.enterpriseai.document.dto;

import com.example.enterpriseai.document.Document;

import java.time.Instant;

public record DocumentResponse(
        Long id,
        String title,
        String fileName,
        String contentType,
        Long projectId,
        String createdBy,
        Instant createdAt
) {
    public static DocumentResponse from(Document document) {
        return new DocumentResponse(
                document.getId(),
                document.getTitle(),
                document.getFileName(),
                document.getContentType(),
                document.getProjectId(),
                document.getCreatedBy(),
                document.getCreatedAt()
        );
    }
}