package com.accenture.academico.service;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.accenture.academico.dto.ClienteDTO;
import com.accenture.academico.dto.DeleteDTO;
import com.accenture.academico.dto.GetClienteDTO;
import com.accenture.academico.dto.MensagemDTO;
import com.accenture.academico.exceptions.CadastroException;
import com.accenture.academico.model.Agencia;
import com.accenture.academico.model.Cliente;
import com.accenture.academico.model.ContaCorrente;
import com.accenture.academico.repository.AgenciaRepository;
import com.accenture.academico.repository.ClienteRepository;
import com.accenture.academico.repository.ContaCorrenteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	AgenciaRepository agRepository;

	@Autowired
	ContaCorrenteRepository ccRepository;

	public void salvarCliente(Cliente cliente) throws CadastroException {

		if (cliente.getCpf() == null) {
			throw new CadastroException("Erro ao cadastrar, CPF não pode estar vazio");
		}
		
		if (clienteRepository.findByCPF(cliente.getCpf()) != null) {
			throw new CadastroException("Erro ao cadastrar, este CPF já está em uso");
		}

		if (cliente.getCpf().length() > 14) {
			throw new CadastroException("Erro ao cadastrar, CPF não pode ter mais de 14 caractéres");
		}

		if (cliente.getTelefone() == null) {
			throw new CadastroException("Erro ao cadastrar, telefone não pode estar vazio");
		}

		if (cliente.getNome() == null) {
			throw new CadastroException("Erro ao cadastrar, nome não pode estar vazio");
		}

	
		

		clienteRepository.save(cliente);
		
	}

	public Cliente fromDTO(ClienteDTO cliente) throws CadastroException {
		
		if (ccRepository.findByNumero(cliente.getNumeroConta()) != null) {
			throw new CadastroException("Número da conta ja existe!");
		}
		
		Cliente cli = new Cliente();
		cli.setCpf(cliente.getCpf());
		cli.setNome(cliente.getNome());
		cli.setTelefone(cliente.getTelefone());
		Agencia ag = agRepository.findById(cliente.getIdAgencia()).orElseThrow();
		cli.setAgencia(ag);
		ContaCorrente cc = new ContaCorrente();
		cc.setNumero(cliente.getNumeroConta());
		cc.setAgencia("0" + ag.getIdAgencia().toString());
		cc.setSaldo(cliente.getSaldo());

		cli.getContacorrente().add(cc);

		ag.getCliente().add(cli);
		cc.setCliente(cli);

		System.out.println(cli.getCpf() + cli.getNome());
        
		return cli;
	}
	
	public MensagemDTO cadastroOk() {
		Calendar cal = new GregorianCalendar();
		String msg = "Cliente cadastrado com sucesso!";
		MensagemDTO mensagem = new MensagemDTO(HttpStatus.OK.value(), msg, cal.getTime());
		return mensagem;
	}
	
	public DeleteDTO delete(String id) throws CadastroException {
		Long id1 = Long.parseLong(id);
		Calendar cal = new GregorianCalendar();
		
		Cliente cli = clienteRepository.findById(id1).orElse(null);
		
		if (cli == null) {
			throw new CadastroException("Cliente não encontrado!");
		}
		
		
		String msg = "Cliente " + cli.getNome() + " deletado com sucesso!";
		
	    DeleteDTO dto = new DeleteDTO(HttpStatus.OK.value(), msg, cal.getTime());
	    
	    
	    clienteRepository.deleteById(id1);
	    
	    return dto;
	}
	
	public GetClienteDTO buscaCliente(String id) throws CadastroException {
		Long id1 = Long.parseLong(id);
		Cliente cli = clienteRepository.findById(id1).orElse(null);
		
		if (cli == null) {
			throw new CadastroException("Cliente não encontrado");
		}
		
		GetClienteDTO getcli = new GetClienteDTO(cli.getNome(), cli.getCpf(), cli.getTelefone(), cli.getAgencia().getNomeAgencia(), cli.getAgencia().getTelefone());
		return getcli;
	}
}
