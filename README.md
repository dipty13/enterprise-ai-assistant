# Enterprise AI Assistant

A learning project for building a production-style enterprise document assistant.

## Day 1

Implemented:

- Spring Boot project setup
- Health endpoint
- Documents API
- Basic validation
- In-memory document storage

## Endpoints

```text
GET /health
GET /api/documents
POST /api/documents
````

## Day 2

Implemented PostgreSQL persistence using Spring Data JPA.

### Added

- Docker Compose PostgreSQL setup
- `Document` JPA entity
- `DocumentRepository`
- Database-backed `GET /api/documents`
- Database-backed `POST /api/documents`

### How to run PostgreSQL

```bash
docker compose up -d
```