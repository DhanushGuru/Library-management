package com.Library.Library_management.service;

import com.Library.Library_management.entity.Book;
import com.Library.Library_management.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Library.Library_management.exception.BookNotFoundException;
import java.util.Optional;
import java.util.List;
@Service
public class BookService{

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);
    }

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book updateBook){
        Book existing = bookRepository.findById(id).orElseThrow(()->new BookNotFoundException(id));
        
        existing.setTitle(updateBook.getTitle());
        existing.setIsbn(updateBook.getIsbn());
        existing.setGenre(updateBook.getGenre());
        existing.setTotalCopies(updateBook.getTotalCopies());
        existing.setAvailableCopies(updateBook.getAvailableCopies());

        return bookRepository.save(existing);
    }

    public void deleteBook(Long id){
        bookRepository.findById(id)
            .orElseThrow(()-> new BookNotFoundException(id));
        bookRepository.deleteById(id);
        // System.out.println("Successfully deleted the book with id" + id);
    }
}
