package com.crudjava.crudjava.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Conteudo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    //Pedro da Silva
    @Column(length=200, nullable=false)
    private String nome;

    //000.000.000-00
    @Column(length=11, nullable=false)
    private String cpf;

    //+55(00)90000-0000
    @Column(length=13, nullable=false)
    private String numero;
}
