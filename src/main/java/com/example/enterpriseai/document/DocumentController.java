package com.example.enterpriseai.document;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    private final DocumentRepository documentRepository;

    public DocumentController(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @GetMapping
    public List<DocumentResponse> getDocuments() {
        return documentRepository.findAll()
                .stream()
                .map(DocumentResponse::from)
                .collect(Collectors.toList());

    }

    @PostMapping
    public DocumentResponse createDocument(@Valid @RequestBody CreateDocumentRequest request) {
        Document document = new Document(
                request.title(),
                request.fileName(),
                request.contentType(),
                request.projectId(),
                request.createdBy()
        );

        Document savedDocument = documentRepository.save(document);

        return DocumentResponse.from(savedDocument);
    }

    public record CreateDocumentRequest(
            @NotBlank String title,
            @NotBlank String fileName,
            String contentType,
            @NotNull Long projectId,
            @NotBlank String createdBy
    ) {
    }

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
}