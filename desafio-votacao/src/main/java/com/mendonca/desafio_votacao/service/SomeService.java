package com.mendonca.desafio_votacao.service;

import com.mendonca.desafio_votacao.config.CallbackUrlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SomeService {

    private final CallbackUrlConfig callbackUrlConfig;

    @Autowired
    public SomeService(CallbackUrlConfig callbackUrlConfig) {
        this.callbackUrlConfig = callbackUrlConfig;
    }

    public void someMethod() {
        String pautaCallbackUrl = callbackUrlConfig.getPauta();
        String votacaoCallbackUrl = callbackUrlConfig.getVotacao();
        String votoCallbackUrl = callbackUrlConfig.getVoto();
        String apiCallBackUrl = callbackUrlConfig.getCpf();

        
        System.out.println("Pauta Callback URL: " + pautaCallbackUrl);
        System.out.println("Votacao Callback URL: " + votacaoCallbackUrl);
        System.out.println("Voto Callback URL: " + votoCallbackUrl);
        System.out.println("Voto Callback URL: " + apiCallBackUrl);       
    }
    
    public String apiCPF() {
    	System.out.println(callbackUrlConfig.getCpf());
    	return callbackUrlConfig.getCpf();
    }
}
