package com.accenture.academico.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Table(name="CONTA")
@Entity(name="CONTA")
public class ContaCorrente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idContaCorrente;

	
	private String agencia;

	@NotBlank
	private String numero;

	private BigDecimal saldo = new BigDecimal(0);

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "ID_Cliente", referencedColumnName = "id")
	@JsonBackReference
	private Cliente cliente;

	@OneToMany(mappedBy = "conta", cascade = CascadeType.PERSIST)
    @JsonManagedReference
	private List<Extrato> extrato = new ArrayList<>();



}
