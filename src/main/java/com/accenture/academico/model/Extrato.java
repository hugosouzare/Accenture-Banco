package com.accenture.academico.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.accenture.academico.enums.Operacao;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
public class Extrato  implements Serializable {


	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idExtrato;
	

	@Temporal(TemporalType.TIMESTAMP)
	private Date DataHoraMovimento;
	
	private Operacao Operacao;
	

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JsonBackReference
	@JoinColumn(name="ID_CONTA", referencedColumnName = "idContaCorrente")
	private ContaCorrente conta;
	
	
}
