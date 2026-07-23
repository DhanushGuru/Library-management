package com.Library.Library_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler{
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBookNotFound(BookNotFoundException ex){
        ErrorResponse error = new ErrorResponse(
            HttpStatus.NOT_FOUND.value(), 
            ex.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgument(IllegalArgumentException ex){
        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex){
        ErrorResponse error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationError(MethodArgumentNotValidException ex){
        Map<String,String> FieldErrors = new HashMap<>();
        for(FieldError error : ex.getBindingResult().getFieldErrors()){
            FieldErrors.put(error.getField(),error.getDefaultMessage());
        }
        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),"Validation_Error" + FieldErrors.toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
