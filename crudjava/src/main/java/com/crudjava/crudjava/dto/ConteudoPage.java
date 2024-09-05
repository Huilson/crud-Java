package com.crudjava.crudjava.dto;

import java.util.List;

public record ConteudoPage(
    List<ConteudoDTO> conteudo,
    long totalElements,
    int totalPages) {}
