package com.accenture.academico.dto;

import lombok.Data;

@Data
public class GetClienteDTO {

	private String nomeCliente;
	private String cpf;
	private String telefone;
	private String agencia;
	private String telefoneAgencia;
	public GetClienteDTO(String nomeCliente, String cpf, String telefone, String agencia, String telefoneAgencia) {
		super();
		this.nomeCliente = nomeCliente;
		this.cpf = cpf;
		this.telefone = telefone;
		this.agencia = agencia;
		this.telefoneAgencia = telefoneAgencia;
	}
	
	
}
