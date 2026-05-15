package com.example.enterpriseai;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    private final List<Map<String, Object>> documents = new ArrayList<>();

    @GetMapping
    public List<Map<String, Object>> getDocuments() {
        return documents;
    }

    @PostMapping
    public Map<String, Object> createDocument(@Valid @RequestBody CreateDocumentRequest request) {
        Map<String, Object> document = Map.of(
                "id", documents.size() + 1,
                "title", request.title(),
                "fileName", request.fileName(),
                "contentType", request.contentType(),
                "createdAt", Instant.now().toString()
        );

        documents.add(document);
        return document;
    }

    public record CreateDocumentRequest(
            @NotBlank String title,
            @NotBlank String fileName,
            String contentType
    ) {
    }
}