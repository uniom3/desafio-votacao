package com.mendonca.desafio_votacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mendonca.desafio_votacao.config.CallbackUrlConfig;
//import com.mendonca.desafio_votacao.config.CallbackUrlConfig;
import com.mendonca.desafio_votacao.converter.PautaConverter;
import com.mendonca.desafio_votacao.dto.PautaDTO;
import com.mendonca.desafio_votacao.entity.Pauta;
import com.mendonca.desafio_votacao.service.PautaService;

@RestController
@RequestMapping("/pautas")
public class PautaController {

	@Autowired
	private PautaService pautaService;

	@Autowired
	private PautaConverter pautaConverter;

	private final CallbackUrlConfig callbackUrlConfig;

	@Autowired
	public PautaController(PautaService pautaService, CallbackUrlConfig callbackUrlConfig) {
		this.pautaService = pautaService;
		this.callbackUrlConfig = callbackUrlConfig;
	}

	@PostMapping
	public ResponseEntity<String> createPauta(@RequestBody PautaDTO pautaDTO) {
		try {
			Pauta pauta = pautaConverter.toEntity(pautaDTO);
			pautaService.save(pauta);
			return ResponseEntity.ok().body("Pauta criada com sucesso.");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Erro ao criar Pauta.");
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<PautaDTO> getPautaById(@PathVariable Long id) {
		Pauta pauta = pautaService.findById(id);
		PautaDTO responseDTO = pautaConverter.toDto(pauta);
		return ResponseEntity.ok(responseDTO);
	}

	@GetMapping
	public ResponseEntity<List<Pauta>> getAllPautas() {
		return new ResponseEntity<>(pautaService.getAllPautas(), HttpStatus.OK);
	}
}
