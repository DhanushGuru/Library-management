package com.Library.Library_management.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Library.Library_management.dto.AuthorRequestDTO;
import com.Library.Library_management.dto.AuthorResponseDTO;
import com.Library.Library_management.entity.Author;
import com.Library.Library_management.service.AuthorService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AurthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<AuthorResponseDTO>> getAllAuthor() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDTO> getAuthorById(@PathVariable Long id) {
        AuthorResponseDTO author = authorService.getAuthorById(id);
        return ResponseEntity.ok(author);
    }
    
    @PostMapping
    public ResponseEntity<AuthorResponseDTO> addAuthor(@Valid @RequestBody AuthorRequestDTO dto) {
        AuthorResponseDTO savedAuthor = authorService.addAuthor(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAuthor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponseDTO> updateAuthor(@PathVariable Long id,
            @Valid @RequestBody AuthorRequestDTO dto) {
        AuthorResponseDTO updateBook = authorService.updateAuthor(id, dto);
        return ResponseEntity.ok(updateBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}
