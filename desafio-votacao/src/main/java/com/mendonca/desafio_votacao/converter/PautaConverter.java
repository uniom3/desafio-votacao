package com.mendonca.desafio_votacao.converter;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mendonca.desafio_votacao.dto.PautaDTO;
import com.mendonca.desafio_votacao.entity.Pauta;

@Service
public class PautaConverter {

	 public PautaDTO toDto(Pauta pauta) {
	        if (pauta == null) {
	            return null;
	        }

	        PautaDTO pautaDTO = new PautaDTO();
	        pautaDTO.setId(pauta.getId());
	        pautaDTO.setAssunto(pauta.getAssunto());
	        if (pauta.getVotacao() != null) {
	            pautaDTO.setVotacaoIds(pauta.getVotacao().stream()
	                                        .map(votacao -> votacao.getId())
	                                        .collect(Collectors.toList()));
	        }

	        return pautaDTO;
	    }

	    public Pauta toEntity(PautaDTO pautaDTO) {
	        if (pautaDTO == null) {
	            return null;
	        }

	        Pauta pauta = new Pauta();
	        pauta.setId(pautaDTO.getId());
	        pauta.setAssunto(pautaDTO.getAssunto());
	        // Note: Setting Votacao entities requires additional lookup logic.
	        // pauta.setVotacao(votacaoRepository.findAllById(pautaDTO.getVotacaoIds()));

	        return pauta;
	    }
	}
