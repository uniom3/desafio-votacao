package com.mendonca.desafio_votacao.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PautaDTO {

    private Long id;
    private String assunto;
    private List<Long> votacaoIds; // Lista de IDs das votações associadas
}
