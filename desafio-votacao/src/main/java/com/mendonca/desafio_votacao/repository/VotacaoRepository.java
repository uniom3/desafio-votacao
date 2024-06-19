package com.mendonca.desafio_votacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mendonca.desafio_votacao.entity.Votacao;

@Repository
public interface VotacaoRepository  extends JpaRepository<Votacao, Long>{

}
