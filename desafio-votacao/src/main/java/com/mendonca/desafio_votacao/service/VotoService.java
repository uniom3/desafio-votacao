package com.mendonca.desafio_votacao.service;

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
public class VotoService {
	
	@Autowired
	private VotoRepository votoRepository;
	
	@Autowired
	private VotacaoRepository votacaoRepository;
	
	 public Voto createVoto(Voto voto) {
		 Optional<Votacao> votacao = votacaoRepository.findById(voto.getVotacao().getId());
		 if(votacao.get().getHorarioFinal().isAfter( voto.getHorarioDoVoto())) {
			 return votoRepository.save(voto);
		 }
	        return null;
	    }

	    public List<Voto> getAllVotos() {
	        return votoRepository.findAll();
	    }	
	    
	    public Voto findById(Long id) {
	        Optional<Voto> voto = votoRepository.findById(id);
	        if (voto.isPresent()) {
	            return voto.get();
	        } else {
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Votacao not found with id: " + id);
	        }
	    }

}
