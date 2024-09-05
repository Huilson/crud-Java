package com.crudjava.crudjava.dto;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConteudoDTO {
    @JsonProperty("_id") 
    private Long id;
    @NotNull 
    @NotBlank 
    @Length(min = 5, max = 200) 
    private String nome;
    @NotNull 
    @Length(min = 11, max = 11) 
    private String cpf;
    @NotNull 
    @Length(min = 13, max = 13) 
    private String numero;
    }
