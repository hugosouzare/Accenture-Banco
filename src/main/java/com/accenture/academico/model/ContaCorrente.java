package com.accenture.academico.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import com.accenture.academico.exceptions.ValorException;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
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

	private Float saldo;

	@OneToOne
	@JoinColumn(name = "ID_Cliente", referencedColumnName = "id")
	private Cliente cliente;

	@OneToMany(mappedBy = "conta")
	@JsonManagedReference
	private List<Extrato> extrato = new ArrayList<>();
	
	
	public void transferencia(ContaCorrente a, ContaCorrente b) {
		
	}

	public void sacar(double value) throws ValorException {
		if (value > this.saldo) {
			throw new ValorException("oimeuchapa");
		}
	}
}
