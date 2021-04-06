package com.accenture.academico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accenture.academico.model.Cliente;
import com.accenture.academico.model.ContaCorrente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	@Query("SELECT c from CLIENTE c where c.cpf=?1")
	public Cliente findByCPF(String cpf);
}
