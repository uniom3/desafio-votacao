package com.mendonca.desafio_votacao.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.mendonca.desafio_votacao.entity.Pauta;
import com.mendonca.desafio_votacao.entity.Voto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VotacaoDTO {
    
    private Long id;
    private Pauta pauta;
    private String cpf;
    private LocalDateTime horarioInicial;
    private LocalDateTime horarioFinal;
    private List<Voto> votos;
}
