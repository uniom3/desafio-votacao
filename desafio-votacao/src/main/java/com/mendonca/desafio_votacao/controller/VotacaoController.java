package com.mendonca.desafio_votacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mendonca.desafio_votacao.config.CallbackUrlConfig;
import com.mendonca.desafio_votacao.converter.VotacaoConverter;
import com.mendonca.desafio_votacao.dto.VotacaoDTO;
import com.mendonca.desafio_votacao.entity.Votacao;
import com.mendonca.desafio_votacao.service.VotacaoService;

@RestController
@RequestMapping("/votacoes")
public class VotacaoController {

	@Autowired
	private VotacaoService votacaoService;

	@Autowired
	private VotacaoConverter votacaoConverter;

	private final CallbackUrlConfig callbackUrlConfig;

	@Autowired
	public VotacaoController(VotacaoService votacaoService, CallbackUrlConfig callbackUrlConfig) {
		this.votacaoService = votacaoService;
		this.callbackUrlConfig = callbackUrlConfig;
	}

	@PostMapping
	public ResponseEntity<String> createVotacao(@RequestBody VotacaoDTO votacaoDTO) {
		try {
			Votacao votacao = votacaoConverter.toEntity(votacaoDTO);
			votacaoService.createVotacao(votacao);
			return ResponseEntity.ok().body("Votação criada com sucesso.");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Erro ao criar Votação.");
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<VotacaoDTO> getVotacaoById(@PathVariable Long id) {
		Votacao votacao = votacaoService.findById(id);
		VotacaoDTO responseDTO = votacaoConverter.toDto(votacao);
		return ResponseEntity.ok(responseDTO);
	}

	@GetMapping
	public ResponseEntity<List<VotacaoDTO>> getAll() {
		List<VotacaoDTO> votosDTO;
		List<Votacao> votos = votacaoService.getAllVotacaos();
		votosDTO = votacaoConverter.toDtoList(votos);
		return ResponseEntity.ok(votosDTO);
	}

	@GetMapping("/resultado/{id}")
	public ResponseEntity<String> getResultadoVotacao(@PathVariable Long id) {
		String resultado = votacaoService.contabilizarVotos(id);
		return ResponseEntity.ok(resultado);
	}
}