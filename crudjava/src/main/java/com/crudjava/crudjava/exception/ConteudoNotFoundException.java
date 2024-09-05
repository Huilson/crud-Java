package com.crudjava.crudjava.exception;

public class ConteudoNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    
    public ConteudoNotFoundException(Long id){
        super ("Item não encontrado. Id da requesição: "+id);
    }
}
