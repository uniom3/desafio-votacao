package com.mendonca.desafio_votacao.service;

import com.mendonca.desafio_votacao.entity.Votacao;
import com.mendonca.desafio_votacao.entity.Voto;
import com.mendonca.desafio_votacao.repository.VotacaoRepository;
import com.mendonca.desafio_votacao.repository.VotoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VotoServiceTest {

    @Mock
    private VotoRepository votoRepository;

    @Mock
    private VotacaoRepository votacaoRepository;

    @InjectMocks
    private VotoService votoService;

    private Votacao votacao;
    private Voto voto;

    @BeforeEach
    void setUp() {
        votacao = new Votacao();
        votacao.setId(1L);
        votacao.setHorarioInicial(LocalDateTime.now());
        votacao.setHorarioFinal(LocalDateTime.now().plusHours(1));

        voto = new Voto();
        voto.setId(1L);
        voto.setCpf("12345678901");
        voto.setVoto(true);
        voto.setVotacao(votacao);
        voto.setHorarioDoVoto(LocalDateTime.now());
    }

    @Test
    void testCreateVotoSuccess() {
        when(votacaoRepository.findById(votacao.getId())).thenReturn(Optional.of(votacao));
        when(votoRepository.save(any(Voto.class))).thenReturn(voto);

        Voto createdVoto = votoService.createVoto(voto);
        assertNotNull(createdVoto);
        assertEquals(voto.getId(), createdVoto.getId());
        verify(votoRepository, times(1)).save(voto);
    }

    @Test
    void testGetAllVotos() {
        when(votoRepository.findAll()).thenReturn(Arrays.asList(voto));

        List<Voto> votos = votoService.getAllVotos();
        assertEquals(1, votos.size());
        assertEquals(voto.getId(), votos.get(0).getId());
        verify(votoRepository, times(1)).findAll();
    }

    @Test
    void testFindByIdSuccess() {
        when(votoRepository.findById(voto.getId())).thenReturn(Optional.of(voto));

        Voto foundVoto = votoService.findById(voto.getId());
        assertNotNull(foundVoto);
        assertEquals(voto.getId(), foundVoto.getId());
        verify(votoRepository, times(1)).findById(voto.getId());
    }

    @Test
    void testFindByIdNotFound() {
        when(votoRepository.findById(voto.getId())).thenReturn(Optional.empty());

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            votoService.findById(voto.getId());
        });

        assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
        verify(votoRepository, times(1)).findById(voto.getId());
    }
}
