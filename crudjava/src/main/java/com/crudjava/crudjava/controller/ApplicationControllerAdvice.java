package com.crudjava.crudjava.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.crudjava.crudjava.exception.ConteudoNotFoundException;

@RestControllerAdvice
public class ApplicationControllerAdvice {
    
    @ExceptionHandler(ConteudoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundException(ConteudoNotFoundException ex){
        return ex.getMessage();
    }
}
