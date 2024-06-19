package com.mendonca.desafio_votacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.mendonca.desafio_votacao.config.CallbackUrlConfig;

@SpringBootApplication
@EnableConfigurationProperties(CallbackUrlConfig.class)
public class DesafioVotacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioVotacaoApplication.class, args);
	}

}
