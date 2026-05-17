package com.example.enterpriseai.document;

import com.example.enterpriseai.document.dto.CreateDocumentRequest;
import com.example.enterpriseai.document.dto.DocumentResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public List<DocumentResponse> getDocuments() {
        return documentRepository.findAll()
                .stream()
                .map(DocumentResponse::from)
                .collect(Collectors.toList());
    }

    public DocumentResponse createDocument(CreateDocumentRequest request) {
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
}