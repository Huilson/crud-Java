package com.crudjava.crudjava.model;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
//@SQLDelete(sql="UPDATE Conteudo SET status = 'Intativo' WHERE id = ?")
//@Where(clause="status = 'Ativo'")
public class Conteudo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    //Pedro da Silva
    @NotNull
    @NotBlank
    @Length(min = 5, max = 200)
    @Column(length=200, nullable=false)
    private String nome;

    //000.000.000-00
    @NotNull
    @Length(min = 11, max = 11)
    @Column(length=11, nullable=false)
    private String cpf;

    //+00(00) 0 0000-0000
    @NotNull
    @Length(min = 13, max = 13)
    @Column(length=13, nullable=false)
    private String numero;

    /*@NotNull
    @Length(min = 5, max = 7)
    @Pattern(regexp="Ativo|Inativo")
    @Column(length=7, nullable=false)
    @JsonIgnore
    private String status = "Ativo";*/
}
