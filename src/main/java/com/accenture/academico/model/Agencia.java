package com.accenture.academico.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Agencia  implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAgencia;

	private String nomeAgencia;

	private String endereco;

	private String telefone;
	
	@OneToMany(mappedBy = "agencia", cascade=CascadeType.MERGE, orphanRemoval = true)
	@JsonIgnore
	private List<Cliente> cliente = new ArrayList<>();
}
