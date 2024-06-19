package com.mendonca.desafio_votacao.entity;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class VotacaoTest {

    @Test
    public void testVotacaoConstructor() {
        Votacao votacao = new Votacao();
        assertNotNull(votacao);
    }

    @Test
    public void testVotacaoGettersAndSetters() {
        Votacao votacao = new Votacao();
        votacao.setId(1L);
        Pauta pautaMock = mock(Pauta.class);
        votacao.setPauta(pautaMock);
        votacao.setHorarioInicial(LocalDateTime.now());
        votacao.setHorarioFinal(LocalDateTime.now());

        assertEquals(Long.valueOf(1L), votacao.getId());
        assertNotNull(votacao.getPauta());
        assertNotNull(votacao.getHorarioInicial());
        assertNotNull(votacao.getHorarioFinal());
    }

    @Test
    public void testVotacaoVotesList() {
        Votacao votacao = new Votacao();
        List<Voto> votesMock = mock(ArrayList.class);
        when(votesMock.size()).thenReturn(1);
        votacao.setVotos(votesMock);

        assertEquals(1, votacao.getVotos().size());
    }

}
