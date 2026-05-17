package com.example.enterpriseai.document.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateDocumentRequest(
        @NotBlank(message = "Title is required")
        String title,

        @NotBlank(message = "File name is required")
        String fileName,

        String contentType,

        @NotNull(message = "Project id is required")
        Long projectId,

        @NotBlank(message = "Created by is required")
        String createdBy
) {
}