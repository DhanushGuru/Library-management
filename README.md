# Library Management System
A Spring Boot REST API project for managing books.

## Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL

## First time setup
```bash
./setup.sh
```

## Run the app
```bash
./mvnw spring-boot:run
```

## API Endpoints
| Method | URL | Description |
|--------|-----|-------------|
| GET | /api/books | Get all books |
| GET | /api/books/{id} | Get book by ID |
| POST | /api/books | Add a new book |
| PUT | /api/books/{id} | Update a book |
| DELETE | /api/books/{id} | Delete a book |
