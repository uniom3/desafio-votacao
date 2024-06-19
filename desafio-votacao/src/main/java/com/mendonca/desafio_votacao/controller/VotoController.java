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
import com.mendonca.desafio_votacao.converter.VotoConverter;
import com.mendonca.desafio_votacao.dto.VotoDTO;
import com.mendonca.desafio_votacao.entity.Voto;
import com.mendonca.desafio_votacao.service.CpfService;
import com.mendonca.desafio_votacao.service.VotoService;

@RestController
@RequestMapping("/votos")
public class VotoController {

	@Autowired
	private VotoService votoService;

	@Autowired
	private VotoConverter votoConverter;

	@Autowired
	private CpfService cpfService;

	private final CallbackUrlConfig callbackUrlConfig;

	@Autowired
	public VotoController(VotoService votoService, CallbackUrlConfig callbackUrlConfig) {
		this.votoService = votoService;
		this.callbackUrlConfig = callbackUrlConfig;
	}

	@PostMapping
	public ResponseEntity<String> createVoto(@RequestBody VotoDTO votoDTO) {
		VotoDTO responseDTO = new VotoDTO();
		try {
			Voto voto = votoConverter.toEntity(votoDTO);
			String validarCpf = cpfService.validarCpf(voto.getCpf()).getBody();
			if (validarCpf.equals("UNABLE_TO_VOTE")) {
				return ResponseEntity.badRequest().body("CPF Nao Ok para votar.");
			}
			votoService.createVoto(voto);
			return ResponseEntity.ok().body("Voto concluido com sucesso.");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Horário da votação excedida.");
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<VotoDTO> getVotoById(@PathVariable Long id) {
		Voto voto = votoService.findById(id);
		VotoDTO responseDTO = votoConverter.toDto(voto);
		return ResponseEntity.ok(responseDTO);
	}

	@GetMapping
	public ResponseEntity<List<VotoDTO>> getAll() {
		List<VotoDTO> votosDTO;
		List<Voto> votos = votoService.getAllVotos();
		votosDTO = votoConverter.toDtoList(votos);
		return ResponseEntity.ok(votosDTO);
	}

}
