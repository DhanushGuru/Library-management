package com.Library.Library_management.exception;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(Long id){
        super("Book not found with this id :" + id);
    }
    public BookNotFoundException(String message){
        super(message);
    }
}