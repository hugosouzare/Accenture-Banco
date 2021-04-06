package com.accenture.academico.dto;

import java.math.BigDecimal;

public class TransferenciaDTO {

	private Long idConta;
	private String contaDestino;
	private String agenciaDestino;
	private BigDecimal valor = new BigDecimal(0);

	public Long getIdConta() {
		return idConta;
	}

	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}

	public String getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}

	public String getAgenciaDestino() {
		return agenciaDestino;
	}

	public void setAgenciaDestino(String agenciaDestino) {
		this.agenciaDestino = agenciaDestino;
	}
	
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TransferenciaDTO(Long idConta, String contaDestino, String agenciaDestino, BigDecimal valor) {
		super();
		this.idConta = idConta;
		this.contaDestino = contaDestino;
		this.agenciaDestino = agenciaDestino;
		this.valor = valor;
	}



}
