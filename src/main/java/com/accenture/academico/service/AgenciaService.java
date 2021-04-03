package com.accenture.academico.service;

import com.accenture.academico.model.Agencia;
import com.accenture.academico.repository.AgenciaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgenciaService {
    
    @Autowired
    AgenciaRepository agenciaRepository;

    public void salvarAgencia(Agencia agencia){
        agenciaRepository.save(agencia);
    }
}
