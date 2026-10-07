package com.Library.Library_management.service;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Library.Library_management.dto.AuthorRequestDTO;
import com.Library.Library_management.dto.AuthorResponseDTO;
import com.Library.Library_management.entity.Author;
import com.Library.Library_management.exception.AuthorNotFoundException;
import com.Library.Library_management.repository.AuthorRepository;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    private Author toEntity(AuthorRequestDTO dto){
        Author author = new Author();
        author.setName(dto.getName());
        author.setEmail(dto.getEmail());
        author.setBio(dto.getBio());
        return author;
    }
    private AuthorResponseDTO toResponseDTO(Author author){
        return new AuthorResponseDTO(
            author.getId(),
            author.getName(), 
            author.getBio(),
            author.getEmail());
    }

    public List<AuthorResponseDTO> getAllAuthors(){
        return authorRepository.findAll()
            .stream()
            .map(this::toResponseDTO)
            .collect(Collectors.toList());
    }

    public AuthorResponseDTO getAuthorById(Long id){
        Author author = authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException(id) );
        return toResponseDTO(author);
    }

    public AuthorResponseDTO addAuthor(AuthorRequestDTO dto){
        Author author = toEntity(dto);
        return toResponseDTO(authorRepository.save(author));
    }
    public AuthorResponseDTO updateAuthor(Long id,AuthorRequestDTO dto){
        Author existing = authorRepository.findById(id).orElseThrow(()-> new AuthorNotFoundException(id));
        existing.setName(dto.getName());
        existing.setEmail(dto.getEmail());
        existing.setBio(dto.getBio());
        return toResponseDTO(authorRepository.save(existing));
    }
    public void deleteAuthor(Long id){
        if(!authorRepository.existsById(id)){
            throw new AuthorNotFoundException(id);
        }
        authorRepository.deleteById(id);
    }
}