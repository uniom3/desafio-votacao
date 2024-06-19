package com.mendonca.desafio_votacao.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mendonca.desafio_votacao.dto.VotoDTO;
import com.mendonca.desafio_votacao.entity.Voto;
import com.mendonca.desafio_votacao.service.CpfService;


@Service
public class VotoConverter {
	
	@Autowired
	private CpfService cpfService;

	 @SuppressWarnings("unlikely-arg-type")
	public VotoDTO toDto(Voto voto) {
	        if (voto == null) {
	            return null;
	        }

	        VotoDTO votoDTO = new VotoDTO();
	        votoDTO.setId(voto.getId());
	        votoDTO.setCpf(voto.getCpf());
	        votoDTO.setVote(voto.getVoto());
	        if (voto.getVotacao() != null) {
	            votoDTO.setVotacao(voto.getVotacao());
	        }        

	        return votoDTO;
	    }

	    public Voto toEntity(VotoDTO votoDTO) {
	        if (votoDTO == null) {
	            return null;
	        }

	        Voto voto = new Voto();
	        voto.setId(votoDTO.getId());
	        voto.setCpf(votoDTO.getCpf());
	        voto.setVoto(votoDTO.getVote());
	        voto.setVotacao(votoDTO.getVotacao());
	        voto.setHorarioDoVoto(votoDTO.getHorarioDoVoto());
	        return voto;
	    }
	    
	    public List<VotoDTO> toDtoList(List<Voto> votos) {
	        return votos.stream().map(this::toDto).collect(Collectors.toList());
	    }
	}