package com.crudjava.crudjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.crudjava.crudjava.model.Conteudo;

@Repository
public interface ConteudoRepository extends JpaRepository<Conteudo, Long>{}
