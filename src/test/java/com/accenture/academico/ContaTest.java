package com.accenture.academico;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.accenture.academico.model.ContaCorrente;

class ContaTest {

	@Test
	void testMostrarExtrato() {
		ContaCorrente cc = new ContaCorrente();
		
		assertTrue(cc.getNumero());
	}

	@Test
	void testCadastroConta() {
		ContaCorrente cc = new ContaCorrente();
		cc.setCliente(cli);
		cc.setNumero("8199832");
		cc.setAgencia("01");
		cc.setNumero("3455-0");
		cc.setSaldo(bd);
		
		assertNotNull(cc.getNumero());
		assertNotNull(cc.getAgencia());
		assertNotNull(cc.getSaldo());
		
	}

}
