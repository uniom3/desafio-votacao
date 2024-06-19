package com.mendonca.desafio_votacao.service;

import com.mendonca.desafio_votacao.entity.Votacao;
import com.mendonca.desafio_votacao.repository.VotacaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class VotacaoServiceTest {

    @InjectMocks
    private VotacaoService votacaoService;

    @Mock
    private VotacaoRepository votacaoRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateVotacao() {
        Votacao votacao = new Votacao();
        when(votacaoRepository.save(any(Votacao.class))).thenReturn(votacao);

        Votacao createdVotacao = votacaoService.createVotacao(votacao);
        assertNotNull(createdVotacao);
        verify(votacaoRepository, times(1)).save(votacao);
    }

    @Test
    void testGetAllVotacaos() {
        Votacao votacao1 = new Votacao();
        Votacao votacao2 = new Votacao();
        when(votacaoRepository.findAll()).thenReturn(Arrays.asList(votacao1, votacao2));

        List<Votacao> votacaos = votacaoService.getAllVotacaos();
        assertEquals(2, votacaos.size());
        verify(votacaoRepository, times(1)).findAll();
    }

    @Test
    void testFindByIdFound() {
        Votacao votacao = new Votacao();
        when(votacaoRepository.findById(anyLong())).thenReturn(Optional.of(votacao));

        Votacao foundVotacao = votacaoService.findById(1L);
        assertNotNull(foundVotacao);
        verify(votacaoRepository, times(1)).findById(1L);
    }

    @Test
    void testFindByIdNotFound() {
        when(votacaoRepository.findById(anyLong())).thenReturn(Optional.empty());

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            votacaoService.findById(1L);
        });

        assertEquals("404 NOT_FOUND \"Votacao not found with id: 1\"", exception.getMessage());
        verify(votacaoRepository, times(1)).findById(1L);
    }
}
