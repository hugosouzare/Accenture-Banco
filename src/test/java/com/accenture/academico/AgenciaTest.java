package com.accenture.academico;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.accenture.academico.model.Agencia;

class AgenciaTest {

	@Test
	void testCadastro() {
		Agencia ag = new Agencia();
		ag.setEndereco("Rua Barao de Souza Leao");
		ag.setNomeAgencia("Agencia 05");
		ag.setTelefone("38229332");
		
		assertNotNull(ag.getEndereco());
		assertNotNull(ag.getNomeAgencia());
		assertNotNull(ag.getTelefone());
	}

	@Test
	void testBusca() {
		Agencia ag = new Agencia();
		
		List<Object> list = new ArrayList<Object>();
		
		assertArrayEquals(ag.getNomeAgencia(), list);
	}

}
