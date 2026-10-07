package com.Library.Library_management.exception;


public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException(Long id){
        super("Author not found with ID : " + id);
    }
    public AuthorNotFoundException(String message){
        super(message);
    }
}
