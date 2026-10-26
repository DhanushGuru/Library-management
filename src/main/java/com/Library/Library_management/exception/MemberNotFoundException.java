package com.Library.Library_management.exception;

public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException(Long id){
        super("Member not found with id:" + id);
    }
    public MemberNotFoundException(String message ){
        super(message);
    }
}



// DEFINES what the error is
// Creates the error object  
// Stores the message 