package com.mendonca.desafio_votacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mendonca.desafio_votacao.entity.Voto;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long>{
	
	List<Voto> findByVotacaoId(Long votacaoId);

}
