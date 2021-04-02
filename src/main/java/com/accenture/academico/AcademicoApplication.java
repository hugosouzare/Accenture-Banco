package com.accenture.academico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.accenture.academico.model.Agencia;
import com.accenture.academico.model.Cliente;
import com.accenture.academico.model.ContaCorrente;
import com.accenture.academico.repository.AgenciaRepository;
import com.accenture.academico.repository.ClienteRepository;
import com.accenture.academico.repository.ContaCorrenteRepository;

@SpringBootApplication
public class AcademicoApplication implements CommandLineRunner {

	@Autowired
	AgenciaRepository agrepo;
	
	@Autowired
	ClienteRepository clirepo;
	
	@Autowired
	ContaCorrenteRepository ccrepo;
	
	public static void main(String[] args) {
		SpringApplication.run(AcademicoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Agencia ag = new Agencia();
		ag.setEndereco("Rua Barao de Souza Leao");
		ag.setNomeAgencia("Agencia 05");
		ag.setTelefone("99999999");
		
		ContaCorrente cc = new ContaCorrente();
		
		Cliente cli = new Cliente();
		cli.setAgencia(ag);
		cli.setCPF("10322211134");
		cli.setNome("Jose Rodrigues");
		cli.setTelefone("81-98994-3322");
		
			
		cc.setCliente(cli);
		cc.setNumero("8199832");
		cc.setAgencia(cli.getAgencia().getNomeAgencia());
		cc.setNumero("3455-0");
		cc.setSaldo((float) 10000);
		
		cli.setContacorrente(cc);

		
		agrepo.save(ag);
		clirepo.save(cli);
		ccrepo.save(cc);

		
	}

}
