package com.crudjava.crudjava.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crudjava.crudjava.dto.ConteudoDTO;
import com.crudjava.crudjava.dto.ConteudoPage;
import com.crudjava.crudjava.service.ConteudoService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;

@Validated
@RestController
@RequestMapping("/api/lista")
@AllArgsConstructor
public class ListaController {

    private final ConteudoService service;

    @GetMapping
    public ConteudoPage listarConteudo(
        @PositiveOrZero @RequestParam(defaultValue = "0") int pagesNo, 
        @Positive  @Max(10) @RequestParam(defaultValue = "10") int pageSize) {
        System.out.println("listando controller!");
        return service.listarConteudo(pagesNo, pageSize);
    }

    @GetMapping("/{id}")
    public ConteudoDTO encontrarId(@PathVariable @NotNull @Positive Long id) {
        System.out.println("buscando controller id: " + id);
        return service.encontrarId(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ConteudoDTO salvarConteudo(@Valid @RequestBody @NotNull ConteudoDTO conteudo) {
        System.out.println("salvou controller!");
        return service.salvarConteudo(conteudo);
    }

    @PutMapping("/{id}")
    public ConteudoDTO atualizarConteudo(@PathVariable @NotNull @Positive Long id,
            @RequestBody @Valid @NotNull ConteudoDTO entity) {
        System.out.println("atualizou controller!");
        return service.conteudo(id, entity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void excluirConteudo(@PathVariable @NotNull @Positive Long id) {
        System.out.println("exclui controller!");
        service.excluirConteudo(id);
    }
}