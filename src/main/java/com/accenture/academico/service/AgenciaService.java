package com.accenture.academico.service;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.accenture.academico.dto.DeleteDTO;
import com.accenture.academico.exceptions.CadastroException;
import com.accenture.academico.model.Agencia;
import com.accenture.academico.model.Cliente;
import com.accenture.academico.repository.AgenciaRepository;

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
    
    public Agencia buscaAgencia(String id) throws CadastroException {
    	Long id1 = Long.parseLong(id);
    	
    	Agencia ag = agenciaRepository.findById(id1).orElse(null);
    	
    	if (ag == null) {
    		throw new CadastroException("Agência não encontrada no nosso banco de dados");
    	
    	}
    	
		return ag;
    }
    
    public DeleteDTO delete(String id) {
		Long id1 = Long.parseLong(id);
		Calendar cal = new GregorianCalendar();
		
		Agencia ag = agenciaRepository.findById(id1).orElse(null);
		
		if (ag == null) {
			throw new CadastroException("Agência não encontrada!");
		}
		
		String msg = "Agencia " + ag.getNomeAgencia() + " deletada com sucesso!";
		
	    DeleteDTO dto = new DeleteDTO(HttpStatus.OK.value(), msg, cal.getTime());
	    
	    
	    agenciaRepository.deleteById(id1);
	    
	    return dto;
	}
}
