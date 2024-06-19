package com.mendonca.desafio_votacao.entity;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class PautaTest {

    @Test
    public void testPautaConstructor() {
        Pauta pauta = new Pauta();
        assertNotNull(pauta);
    }

    @Test
    public void testPautaGettersAndSetters() {
        Pauta pauta = new Pauta();
        pauta.setId(1L);
        pauta.setAssunto("Assunto");
        
        assertEquals(Long.valueOf(1L), pauta.getId());
        assertEquals("Assunto", pauta.getAssunto());
    }

    @Test
    public void testPautaVotacaoList() {
        Pauta pauta = new Pauta();
        List<Votacao> votacaoMock = mock(ArrayList.class);
        when(votacaoMock.size()).thenReturn(1);
        pauta.setVotacao(votacaoMock);
        
        assertEquals(1, pauta.getVotacao().size());
    }

}
