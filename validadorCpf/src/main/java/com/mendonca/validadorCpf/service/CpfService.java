package com.mendonca.validadorCpf.service;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class CpfService {

	private static final Pattern CPF_PATTERN = Pattern.compile("\\d{11}");

	public boolean isValidCpf(String cpf) {
        cpf = cpf.replaceAll("\\D", ""); 
        if (!CPF_PATTERN.matcher(cpf).matches()) {
            return false;
        }
            
        if (cpf.length() != 11 && !cpf.matches("\\d{11}")) {
            return false;
        }
        
        return true;
           
    }
}
