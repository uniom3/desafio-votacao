package com.mendonca.desafio_votacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mendonca.desafio_votacao.entity.Pauta;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long>{
	

}
