package com.accenture.academico.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class OperacaoSucedidaDTO extends DeleteDTO {


	private BigDecimal valor = new BigDecimal(0);
	
	private BigDecimal saldo = new BigDecimal(0);
	
	public OperacaoSucedidaDTO(int status, String msg, Date date, BigDecimal valor, BigDecimal saldo) {
		super(status, msg, date);
		this.valor = valor;
		this.saldo = saldo;
	}
	


}
