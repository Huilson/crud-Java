package com.crudjava.crudjava.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.crudjava.crudjava.model.Conteudo;
import com.crudjava.crudjava.repository.ConteudoRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ConteudoService {
    
    private final ConteudoRepository repository;    

    public List<Conteudo> listarConteudo() {
        System.out.println("listando!");
        return repository.findAll();
    }

    public ResponseEntity<Conteudo> encontrarId(@PathVariable @NotNull @Positive Long id) {
        System.out.println("buscando id: " + id);
        return repository.findById(id).map(object -> ResponseEntity.ok().body(object))
                .orElse(ResponseEntity.notFound().build());
    }

    public Conteudo salvarConteudo(@Valid @RequestBody Conteudo conteudo) {
        System.out.println("salvou!");
        return repository.save(conteudo);
    }

    public ResponseEntity<Conteudo> atualizarConteudo(@PathVariable @NotNull @Positive Long id,
            @RequestBody @Valid Conteudo entity) {
        System.out.println("atualizou!");
        return repository.findById(id).map(item -> {
            item.setNome(entity.getNome());
            item.setCpf(entity.getCpf());
            item.setNumero(entity.getNumero());
            Conteudo update = repository.save(item);
            return ResponseEntity.ok().body(update);
        })
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity excluirConteudo(@PathVariable @NotNull @Positive Long id) {
        System.out.println("exclui!");
        return repository.findById(id).map(item -> {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        })
                .orElse(ResponseEntity.notFound().build());
    }

}
