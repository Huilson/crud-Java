package com.crudjava.crudjava.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import com.crudjava.crudjava.dto.ConteudoDTO;
import com.crudjava.crudjava.dto.ConteudoPage;
import com.crudjava.crudjava.exception.ConteudoNotFoundException;
import com.crudjava.crudjava.model.Conteudo;
import com.crudjava.crudjava.repository.ConteudoRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;

@Validated
@Service
@AllArgsConstructor
public class ConteudoService {

    private final ConteudoRepository repository;
    private final ModelMapper modelMapper;

    public ConteudoPage listarConteudo(
            @PositiveOrZero int pages,
            @Positive @Max(10) int size) {
        System.out.println("listando!");

        Page<Conteudo> pg = repository.findAll(PageRequest.of(pages, size));
        List<ConteudoDTO> dtos = pg.get().map(conteudo -> modelMapper.map(conteudo, ConteudoDTO.class))
                .collect(Collectors.toList());
        return new ConteudoPage(dtos, pg.getTotalElements(), pg.getTotalPages());
    }

    public ConteudoDTO encontrarId(@PathVariable @NotNull @Positive Long id) {
        System.out.println("buscando id: " + id);
        Conteudo conteudo = repository.findById(id).orElseThrow(() -> new ConteudoNotFoundException(id));
        return modelMapper.map(conteudo, ConteudoDTO.class);
    }

    public ConteudoDTO salvarConteudo(@Valid @NotNull ConteudoDTO conteudo) {
        System.out.println("salvou!");
        repository.save(modelMapper.map(conteudo, Conteudo.class));
        return conteudo;
    }

    public ConteudoDTO conteudo(@PathVariable @NotNull @Positive Long id,
            @NotNull @Valid ConteudoDTO conteudo) {
        System.out.println("atualizou!");
        return repository.findById(id).map(item -> {
            item.setNome(conteudo.getNome());
            item.setCpf(conteudo.getCpf());
            item.setNumero(conteudo.getNumero());
            return salvarConteudo(conteudo);
        }).orElseThrow(() -> new ConteudoNotFoundException(id));
    }

    public void excluirConteudo(@PathVariable @NotNull @Positive Long id) {
        System.out.println("exclui!");
        repository.delete(repository.findById(id).orElseThrow(() -> new ConteudoNotFoundException(id)));
    }
}
