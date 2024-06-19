package com.mendonca.desafio_votacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.mendonca.desafio_votacao.config.CallbackUrlConfig;

@Service
public class CpfService {

	@Autowired
	public SomeService someService;

	 private final CallbackUrlConfig callbackUrlConfig;

	    @Autowired
	    public CpfService(CallbackUrlConfig callbackUrlConfig) {
	        this.callbackUrlConfig = callbackUrlConfig;
	    }

	private final RestTemplate restTemplate = new RestTemplate();

	public ResponseEntity<String> validarCpf(String cpf) {
		try {
			String apiUrl = callbackUrlConfig.getCpf();
			ResponseEntity<String> response = restTemplate.getForEntity(apiUrl + cpf, String.class);
			if (response.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("UNABLE_TO_VOTE");
			}
			return response;
		} catch (HttpClientErrorException.NotFound e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("UNABLE_TO_VOTE");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Failed to connect to the external API",
					e);
		}
	}
}
