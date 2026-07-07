package com.Library.Library_management.service;
import com.Library.Library_management.entity.Book;
import com.Library.Library_management.repository.BookRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.service;

public class BookService{

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(){
        return bookRepository.findById(id);
    }

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book updateBook){
        Book existing = bookRepository.findById(id).orElseThrow(()->new RunTimeException("No book found with this id" + id));
        
        existing.setTitle(updateBook.getTitle());
        existing.setIsbn(updateBook.getIsbn());
        existing.setGenre(updateBook.getGenre());
        existing.setTotalcopies(updateBook.getTotalcopies());
        existing.setAvailablecopies(updateBook.getAvailablecopies());

        return bookRepository.save(existing);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
        // System.out.println("Successfully deleted the book with id" + id);
    }
}
