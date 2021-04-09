package com.accenture.academico;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.accenture.academico.model.Agencia;
import com.accenture.academico.model.Cliente;
import com.accenture.academico.model.ContaCorrente;
import com.accenture.academico.repository.AgenciaRepository;
import com.accenture.academico.repository.ClienteRepository;
import com.accenture.academico.repository.ContaCorrenteRepository;
import com.accenture.academico.repository.ExtratoRepository;

@SpringBootApplication
public class AcademicoApplication implements CommandLineRunner {

	@Autowired
	AgenciaRepository agrepo;

	@Autowired
	ClienteRepository clirepo;

	@Autowired
	ContaCorrenteRepository ccrepo;

	@Autowired
	ExtratoRepository extrepo;

	public static void main(String[] args) {
		SpringApplication.run(AcademicoApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Agencia ag = new Agencia();
		ag.setEndereco("Rua Barao de Souza Leao");
		ag.setNomeAgencia("Agencia 05");
		ag.setTelefone("38229332");
		
		Agencia ag2 = new Agencia();
		ag2.setEndereco("Rua Jose Moreira Leal");
		ag2.setNomeAgencia("Agencia 02");
		ag2.setTelefone("2122-3366");
		
		Agencia ag3 = new Agencia();
		ag3.setEndereco("Rua da Matriz");
		ag3.setNomeAgencia("Agencia 03");
		ag3.setTelefone("3442-2811");
		
		ContaCorrente cc = new ContaCorrente();
		
		Cliente cli = new Cliente();
		cli.setAgencia(ag);
		cli.setCpf("107.943.854-86");
		cli.setNome("Jose Rodrigues");
		cli.setTelefone("81-98994-3322");
		
		BigDecimal bd = new BigDecimal(1000);
		cc.setCliente(cli);
		cc.setNumero("8199832");
		cc.setAgencia("01");
		cc.setNumero("3455-0");
		cc.setSaldo(bd);
		
		cli.getContacorrente().add(cc);
		
		
		agrepo.saveAll(Arrays.asList(ag, ag2, ag3));
		clirepo.save(cli);
		ccrepo.save(cc);

	}


}
