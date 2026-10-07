package com.Library.Library_management.service;

import com.Library.Library_management.dto.BookRequestDTO;
import com.Library.Library_management.dto.BookResponseDTO;
import com.Library.Library_management.entity.*;
import com.Library.Library_management.repository.AuthorRepository;
import com.Library.Library_management.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Library.Library_management.exception.*;
import java.util.stream.Collectors;
import java.util.List;

@Service
public class BookService{

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    private Book toEntity(BookRequestDTO dto){
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setIsbn(dto.getIsbn());
        book.setGenre(dto.getGenre());
        book.setTotalCopies(dto.getTotalCopies());
        book.setAvailableCopies(dto.getAvailableCopies());
        if(dto.getAuthorId() != null){
            Author author = authorRepository.findById(dto.getAuthorId())
                                .orElseThrow(()->new AuthorNotFoundException(dto.getAuthorId()));
            book.setAuthor(author);
        }
        return book;
    }

    private BookResponseDTO toResponseDTO(Book book){
        String authorName = book.getAuthor() != null ? book.getAuthor().getName() : "unknown";
        return new BookResponseDTO(
            book.getId(),
            book.getTitle(),
            book.getIsbn(),
            book.getGenre(),
            book.getTotalCopies(),
            book.getAvailableCopies(),
            authorName
        );
    }
    public List<BookResponseDTO> getAllBooks(){
        return bookRepository.findAll()
        .stream()
        .map(this::toResponseDTO)
        .collect(Collectors.toList());
    }

    public BookResponseDTO getBookById(Long id){
        Book book = bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException(id));
        return toResponseDTO(book);
    }

    public BookResponseDTO addBook(BookRequestDTO dto){
        Book book = toEntity(dto);
        Book savedBook = bookRepository.save(book);
        return toResponseDTO(savedBook);
    }

    public BookResponseDTO updateBook(Long id, BookRequestDTO dto){
        Book existing = bookRepository.findById(id).orElseThrow(()->new BookNotFoundException(id));
        
        existing.setTitle(dto.getTitle());
        existing.setIsbn(dto.getIsbn());
        existing.setGenre(dto.getGenre());
        existing.setTotalCopies(dto.getTotalCopies());
        existing.setAvailableCopies(dto.getAvailableCopies());

        
        return toResponseDTO(bookRepository.save(existing));
    }

    public void deleteBook(Long id){
        if(!bookRepository.existsById(id)){
           throw new BookNotFoundException(id);
        }
        bookRepository.deleteById(id);
        // System.out.println("Successfully deleted the book with id" + id);
    }
}
