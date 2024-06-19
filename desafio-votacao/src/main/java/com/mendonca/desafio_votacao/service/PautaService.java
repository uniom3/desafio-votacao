package com.mendonca.desafio_votacao.service;

import com.mendonca.desafio_votacao.entity.Pauta;
import com.mendonca.desafio_votacao.entity.Voto;
import com.mendonca.desafio_votacao.repository.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;

@Service
public class PautaService {

    @Autowired
    private PautaRepository pautaRepository;

    public Pauta save(Pauta pauta) {
        return pautaRepository.save(pauta);
    }

    public Pauta findById(Long id) {
        Optional<Pauta> pauta = pautaRepository.findById(id);
        if (pauta.isPresent()) {
            return pauta.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pauta not found with id: " + id);
        }
    }
    
    public List<Pauta> getAllPautas() {
        return pautaRepository.findAll();
    }	
    
    
}
