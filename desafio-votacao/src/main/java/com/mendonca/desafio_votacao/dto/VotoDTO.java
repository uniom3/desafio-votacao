package com.mendonca.desafio_votacao.dto;

import java.time.LocalDateTime;

import com.mendonca.desafio_votacao.entity.Votacao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VotoDTO {
    
    private Long id;
    private String cpf;
    private Boolean vote;
    private Votacao votacao;
    private String cpfValidado;
    private LocalDateTime horarioDoVoto;
}
