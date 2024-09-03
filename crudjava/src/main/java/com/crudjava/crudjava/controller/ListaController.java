package com.crudjava.crudjava.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crudjava.crudjava.model.Conteudo;
import com.crudjava.crudjava.service.ConteudoService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;



@Validated
@RestController
@RequestMapping("/api/lista")
@AllArgsConstructor
public class ListaController {

    private final ConteudoService service;

    @GetMapping
    public List<Conteudo> listarConteudo(){
        System.out.println("listando!");
        return service.listarConteudo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conteudo> encontrarId(@PathVariable @NotNull @Positive Long id) {
        System.out.println("buscando id: "+id);        
        return service.encontrarId(id);        
    }    

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Conteudo salvarConteudo(@Valid @RequestBody Conteudo conteudo){
        System.out.println("salvou!");
        return service.salvarConteudo(conteudo);
    }

    @PutMapping("/{id}")    
    public ResponseEntity<Conteudo> atualizarConteudo(@PathVariable @NotNull @Positive Long id, 
    @RequestBody @Valid Conteudo entity) {
        System.out.println("atualizou!");
        return service.atualizarConteudo(id, entity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity excluirConteudo(@PathVariable @NotNull @Positive Long id){
        System.out.println("exclui!");
        return service.excluirConteudo(id);
    }
}