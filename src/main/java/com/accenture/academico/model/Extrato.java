package com.accenture.academico.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Table(name="EXTRATO")
@Entity(name="EXTRATO")
public class Extrato  implements Serializable {


	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idExtrato;
	

	
	private Date dataHoraMovimento;
	
	private String operacao;
	

	@ManyToOne(cascade=CascadeType.MERGE)
	@JsonBackReference
	@JoinColumn(name="ID_CONTACORRENTE", referencedColumnName = "idContaCorrente")
	private ContaCorrente conta;
	
	private BigDecimal valorOperacao = new BigDecimal(0);
}
