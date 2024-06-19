package com.mendonca.desafio_votacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mendonca.desafio_votacao.service.CpfService;


@RestController
@RequestMapping("/validador")
public class CpfController {

    @Autowired
    private CpfService cpfService;

    @GetMapping("/{cpf}")
    public ResponseEntity<ResponseEntity<String>> validarCpf(@PathVariable String cpf) {
    	
        ResponseEntity<String> result = cpfService.validarCpf(cpf);
        return ResponseEntity.ok(result);
    }
}