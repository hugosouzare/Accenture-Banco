package com.accenture.academico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accenture.academico.model.ContaCorrente;

public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long>{

	@Query("SELECT c from CONTA c where c.numero=?1 and c.agencia=?2")
	public ContaCorrente getContaTransferencia(String numero, String agencia);
}
