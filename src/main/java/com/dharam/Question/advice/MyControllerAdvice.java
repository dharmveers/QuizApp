package com.dharam.Question.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class MyControllerAdvice {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> NoSuchElementFound(){
        return  new ResponseEntity<>("This user does not exist", HttpStatus.BAD_REQUEST);
    }
}
