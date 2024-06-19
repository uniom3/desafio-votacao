package com.mendonca.desafio_votacao.service;

import com.mendonca.desafio_votacao.entity.Pauta;
import com.mendonca.desafio_votacao.repository.PautaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PautaServiceTest {

    @InjectMocks
    private PautaService pautaService;

    @Mock
    private PautaRepository pautaRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        Pauta pauta = new Pauta();
        when(pautaRepository.save(any(Pauta.class))).thenReturn(pauta);

        Pauta savedPauta = pautaService.save(pauta);
        assertNotNull(savedPauta);
        verify(pautaRepository, times(1)).save(pauta);
    }

    @Test
    void testFindByIdFound() {
        Pauta pauta = new Pauta();
        when(pautaRepository.findById(anyLong())).thenReturn(Optional.of(pauta));

        Pauta foundPauta = pautaService.findById(1L);
        assertNotNull(foundPauta);
        verify(pautaRepository, times(1)).findById(1L);
    }

    @Test
    void testFindByIdNotFound() {
        when(pautaRepository.findById(anyLong())).thenReturn(Optional.empty());

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            pautaService.findById(1L);
        });

        assertEquals("404 NOT_FOUND \"Pauta not found with id: 1\"", exception.getMessage());
        verify(pautaRepository, times(1)).findById(1L);
    }
}
