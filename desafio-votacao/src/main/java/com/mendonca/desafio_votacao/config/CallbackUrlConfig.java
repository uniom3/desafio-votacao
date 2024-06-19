package com.mendonca.desafio_votacao.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "callback.url")
public class CallbackUrlConfig {

    private String pauta;
    private String votacao;
    private String voto;
    private String cpf;
    
    public String Teste() {
    	System.out.println(cpf);
		return cpf;
    }

}
