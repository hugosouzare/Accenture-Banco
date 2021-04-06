package com.accenture.academico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.academico.dto.ClienteDTO;
import com.accenture.academico.exceptions.CadastroException;
import com.accenture.academico.model.Agencia;
import com.accenture.academico.model.Cliente;
import com.accenture.academico.model.ContaCorrente;
import com.accenture.academico.repository.AgenciaRepository;
import com.accenture.academico.repository.ClienteRepository;
import com.accenture.academico.repository.ContaCorrenteRepository;

import java.util.List;

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

		if (cliente.getCpf().length() > 14) {
			throw new CadastroException("Erro ao cadastrar, CPF não pode ter mais de 14 caractéres");
		}

		if (cliente.getTelefone() == null) {
			throw new CadastroException("Erro ao cadastrar, telefone não pode estar vazio");
		}

		if (cliente.getNome() == null) {
			throw new CadastroException("Erro ao cadastrar, nome não pode estar vazio");
		}

		List<Cliente> ccpf = clienteRepository.findAll();

		if (ccpf.stream().anyMatch(c -> c.getCpf().contentEquals(cliente.getCpf()))) {
			throw new CadastroException("CLIENTE NÃO CADASTRADO!: CPF já está em uso");
		}
		
		

		clienteRepository.save(cliente);
		ccRepository.saveAll(cliente.getContacorrente());
	}

	public Cliente fromDTO(ClienteDTO cliente) {
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
}
