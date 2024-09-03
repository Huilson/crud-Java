package com.crudjava.crudjava.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/{id}")
    public ResponseEntity<Conteudo> encontrarId(@PathVariable Long id) {
        System.out.println("buscando id: "+id);        
        return repository.findById(id).map(object -> ResponseEntity.ok().body(object))
        .orElse(ResponseEntity.notFound().build());
    }    

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Conteudo salvarConteudo(@RequestBody Conteudo conteudo){
        System.out.println("salvou!");
        return repository.save(conteudo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conteudo> atualizarConteudo(@PathVariable Long id, @RequestBody Conteudo entity) {
        return repository.findById(id).map(novo -> {
            novo.setNome(entity.getNome());
            novo.setCpf(entity.getCpf());
            novo.setNumero(entity.getNumero());
            Conteudo update = repository.save(novo);
            return ResponseEntity.ok().body(update);
        })
        .orElse(ResponseEntity.notFound().build());
    }

}
