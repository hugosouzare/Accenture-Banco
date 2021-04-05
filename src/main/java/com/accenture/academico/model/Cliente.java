package com.accenture.academico.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	
	@OneToOne(mappedBy = "cliente", cascade=CascadeType.PERSIST)
	private ContaCorrente contacorrente;
	
}
