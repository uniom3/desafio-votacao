package com.mendonca.validadorCpf.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mendonca.validadorCpf.service.CpfService;

@RestController
@RequestMapping("/api/cpf")
public class CpfController {

	@Autowired
    private final CpfService cpfService;

    public CpfController(CpfService cpfService) {
        this.cpfService = cpfService;
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<String> validateCpf(@PathVariable String cpf) {
        if (!cpfService.isValidCpf(cpf)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("UNABLE_TO_VOTE");
        }
        return ResponseEntity.ok("ABLE_TO_VOTE");
    }
}