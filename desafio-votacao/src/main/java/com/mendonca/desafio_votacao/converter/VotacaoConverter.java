package com.mendonca.desafio_votacao.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mendonca.desafio_votacao.dto.VotacaoDTO;
import com.mendonca.desafio_votacao.dto.VotoDTO;
import com.mendonca.desafio_votacao.entity.Votacao;
import com.mendonca.desafio_votacao.entity.Voto;

@Service
public class VotacaoConverter {
	
	 public VotacaoDTO toDto(Votacao votacao) {
	        if (votacao == null) {
	            return null;
	        }

	        VotacaoDTO votacaoDTO = new VotacaoDTO();
	        votacaoDTO.setId(votacao.getId());
	        votacaoDTO.setPauta(votacao.getPauta());
	        votacaoDTO.setHorarioInicial(votacao.getHorarioInicial());
	        votacaoDTO.setHorarioFinal(votacao.getHorarioFinal());
	        votacaoDTO.setVotos(votacao.getVotos().stream().collect(Collectors.toList()));

	        return votacaoDTO;
	    }
	 
	 
	  public Votacao toEntity(VotacaoDTO votacaoDTO) {
	        if (votacaoDTO == null) {
	            return null;
	        }

	        Votacao votacao = new Votacao();
	        votacao.setId(votacaoDTO.getId());
	        votacao.setPauta(votacaoDTO.getPauta());
	        votacao.setHorarioInicial(votacaoDTO.getHorarioInicial());
	        votacao.setHorarioFinal(votacaoDTO.getHorarioFinal());
	        votacao.setVotos(votacaoDTO.getVotos().stream().collect(Collectors.toList()));

	        return votacao;
	    }
	  
	  public List<VotacaoDTO> toDtoList(List<Votacao> votos) {
	        return votos.stream().map(this::toDto).collect(Collectors.toList());
	    }

}
