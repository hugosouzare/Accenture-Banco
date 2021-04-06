package com.accenture.academico.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long idAgencia;
	
	
	private String nome;
	
	private String cpf;
	
	private String telefone;
	
	private String numeroConta;
	
	private BigDecimal saldo = new BigDecimal(0);
	
	
}
