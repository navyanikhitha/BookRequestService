package com.book.store.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.book.store.dtos.ExceptionDTO;
import com.book.store.exception.BookLimitExceededException;
import com.book.store.exception.ResourceNotFoundException;

@ControllerAdvice
public class ExceptionRestHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleResourceNotFoundException(ResourceNotFoundException exception){
        return new ResponseEntity<>(new ExceptionDTO(exception.getMessage()), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(BookLimitExceededException.class)
    public ResponseEntity<ExceptionDTO> handleBookLimitExceededException(BookLimitExceededException exception){
        return new ResponseEntity<>(new ExceptionDTO(exception.getMessage()), HttpStatus.NOT_FOUND);
    }
}
