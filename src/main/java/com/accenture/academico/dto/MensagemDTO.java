package com.accenture.academico.dto;

import java.math.BigDecimal;
import java.util.Date;

public class MensagemDTO {

	private int status;
	private String msg;
	private BigDecimal valor = new BigDecimal(0);
	private Date data;
	private String titular;
	private String titularRecebido;
	

	

	public MensagemDTO(int status, String msg, BigDecimal valor, Date data, String titular, String titularRecebido) {
		super();
		this.status = status;
		this.msg = msg;
		this.valor = valor;
		this.data = data;
		this.titular = titular;
		this.titularRecebido = titularRecebido;
	}
	
	public MensagemDTO(int status, String msg, Date data) {
		super();
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getTitularRecebido() {
		return titularRecebido;
	}

	public void setTitularRecebido(String titularRecebido) {
		this.titularRecebido = titularRecebido;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
