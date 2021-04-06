package com.accenture.academico.model;

import java.io.Serializable;
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

import lombok.Data;

@Data
@Entity
public class Cliente  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	

	private String nome;


	private String cpf;
	

	private String telefone;
	

	@ManyToOne
	@JoinColumn(name="ID_AGENCIA", referencedColumnName = "idAgencia")
	private Agencia agencia;
	
	@OneToMany(mappedBy = "cliente", cascade=CascadeType.MERGE)
	private List<ContaCorrente> contacorrente = new ArrayList<>();
	
}
