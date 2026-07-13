package com.Library.Library_management.Controller;

// import java.net.ResponseCache;

import com.Library.Library_management.entity.Book;
import com.Library.Library_management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.List;
import java.Optional;

@RestController
@RequestMapping("/api/books")
public class RestController{
    public class BookController{
        @Autowired
        private BookService bookService;

        @GetMapping
        public ResponseEntity<List<Book>> getAllBiooks(){
            List<Book> books = bookService.getAllBooks();
            return ResponseEntity.ok(books);
        } 

        @PutMapping("/{id}")
        public ResponseEntity<Book> getbookById(@pathVariable Long id){
            optional<Book> book = bookService.getBookById();
            return book.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
        }

        @PostMapping()
        public ResponseEntity<Book> addBook(@RequestBody Book book){
            Book savedBook = bookService.addBook(book);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
        }
        @PutMapping("/{id}")
        public ResponseEntity<Book> updateBook(@pathVariable Long id,@RequestBody Book book){
            Book updateBook = bookService.updateBook(id,book);
            return ResponseEntity.ok(updateBook);
        }
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteBook(@pathVariable Long id){
            bookService.deleteBook(id);
            return ResponseEntity.noContent().build();
        }
    }
}