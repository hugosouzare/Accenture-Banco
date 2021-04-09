package com.accenture.academico;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.accenture.academico.model.Cliente;

import lombok.Data;

@Data
class ClienteTest {
	
	@Test
	void testInsertClienteDTO() {
		Cliente cli = new Cliente();
		cli.setAgencia(ag);
		cli.setCpf("107.943.854-86");
		cli.setNome("Jose Rodrigues");
		cli.setTelefone("81-98994-3322");
		
		assertNotNull(cli.getCpf());
		assertNotNull(cli.getNome());
		assertNotNull(cli.getTelefone());
	}

	@Test
	void testBuscaCliente() {
		Cliente cli = new Cliente();
		List<Object> list = new ArrayList<Object>();
		
		assertEquals(cli.getCpf(), list);
	}

}
