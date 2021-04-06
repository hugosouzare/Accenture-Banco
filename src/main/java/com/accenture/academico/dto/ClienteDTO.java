package com.accenture.academico.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;

@Data
public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long idAgencia;
	
	
	private String nome;
	
	@Pattern(regexp="([0-9]{3}[.]?[0-9]{3}[.]?[0-9]{3}-[0-9]{2})|([0-9]{11})")
 	private String cpf;
	
	private String telefone;
	
	private String numeroConta;
	
	private BigDecimal saldo = new BigDecimal(0);
	
	
}
