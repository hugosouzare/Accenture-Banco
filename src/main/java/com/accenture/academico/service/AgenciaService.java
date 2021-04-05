package com.accenture.academico.service;

import com.accenture.academico.exceptions.CadastroException;
import com.accenture.academico.model.Agencia;
import com.accenture.academico.repository.AgenciaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgenciaService {
    
    @Autowired
    AgenciaRepository agenciaRepository;

    public void salvarAgencia(Agencia agencia) throws CadastroException {
    	
    	if (agencia.getEndereco() == null ) {
    		throw new CadastroException("Erro ao cadastrar, endereço não pode estar vazio");
    	}
    	
    	if (agencia.getNomeAgencia() == null ) {
    		throw new CadastroException("Erro ao cadastrar, nome da agência não pode estar vazio");
    	}
    	
    	if (agencia.getTelefone() == null) {
    		throw new CadastroException("Erro ao cadastrar, telefone não pode estar vazio");
    	}
    	
        agenciaRepository.save(agencia);
    }
}
