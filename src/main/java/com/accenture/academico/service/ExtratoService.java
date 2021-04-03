package com.accenture.academico.service;

import com.accenture.academico.model.Extrato;
import com.accenture.academico.repository.ExtratoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExtratoService {
    
    @Autowired
    ExtratoRepository extratoRepository;

    public void salvarExtrato(Extrato extrato) {
        extratoRepository.save(extrato);
    }
}
