package com.accenture.academico.service;

import com.accenture.academico.model.Cliente;
import com.accenture.academico.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository clienteRepository;

    public void salvarCliente(Cliente agencia){
        clienteRepository.save(agencia);
    }
}
