package com.accenture.academico.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class OperacaoDTO {

	private Long contaId;
	private int operacao;
	private BigDecimal valor = new BigDecimal(0);
	
	public OperacaoDTO(Long contaId, int operacao, BigDecimal valor) {
		super();
		this.contaId = contaId;
		this.operacao = operacao;
		this.valor = valor;
	}
	
}
