package com.mendonca.desafio_votacao.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mendonca.desafio_votacao.entity.Votacao;
import com.mendonca.desafio_votacao.entity.Voto;
import com.mendonca.desafio_votacao.repository.VotacaoRepository;
import com.mendonca.desafio_votacao.repository.VotoRepository;

@Service
public class VotacaoService {

    @Autowired
    private VotacaoRepository votacaoRepository;

    @Autowired
    private VotoRepository votoRepository;

    public Votacao createVotacao(Votacao votacao) {
        if (votacao.getHorarioInicial() == null) {
            votacao.setHorarioInicial(LocalDateTime.now());
        }
        if (votacao.getHorarioFinal() == null) {
            votacao.setHorarioFinal(votacao.getHorarioInicial().plusMinutes(1));
        }
        return votacaoRepository.save(votacao);
    }

    public List<Votacao> getAllVotacaos() {
        return votacaoRepository.findAll();
    }

    public Votacao findById(Long id) {
        Optional<Votacao> votacao = votacaoRepository.findById(id);
        if (votacao.isPresent()) {
            return votacao.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Votacao not found with id: " + id);
        }
    }

    public String contabilizarVotos(Long votacaoId) {
        Votacao votacao = findById(votacaoId);
        List<Voto> votos = votacao.getVotos();
        votos = votoRepository.findByVotacaoId(votacaoId);

        long votosSim = votos.stream().filter(Voto::getVoto).count();
        long votosNao = votos.stream().filter(voto -> !voto.getVoto()).count();

        return "Resultado da Votação: Sim = " + votosSim + ", Não = " + votosNao;
    }
}
