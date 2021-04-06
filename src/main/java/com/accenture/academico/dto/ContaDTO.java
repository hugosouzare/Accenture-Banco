package com.accenture.academico.dto;

import java.math.BigDecimal;

public class ContaDTO {

	private Long idCliente;
	private String contaNumero;
	private BigDecimal saldo = new BigDecimal(0);

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getContaNumero() {
		return contaNumero;
	}

	public void setContaNumero(String contaNumero) {
		this.contaNumero = contaNumero;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public ContaDTO(Long idCliente, String contaNumero, BigDecimal saldo) {
		super();
		this.idCliente = idCliente;
		this.contaNumero = contaNumero;
		this.saldo = saldo;
	}

}
