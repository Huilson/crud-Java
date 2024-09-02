package com.crudjava.crudjava.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crudjava.crudjava.model.Conteudo;
import com.crudjava.crudjava.repository.ConteudoRepository;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/lista")
@AllArgsConstructor
public class ListaController {

    private final ConteudoRepository repository;

    @GetMapping
    public List<Conteudo> listarConteudo(){
        System.out.println("listando!");
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Conteudo salvarConteudo(@RequestBody Conteudo conteudo){
        System.out.println("salvou!");
        return repository.save(conteudo);        
        //return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(conteudo));
    }

}
