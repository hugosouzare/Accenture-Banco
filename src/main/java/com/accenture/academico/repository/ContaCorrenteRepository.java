package com.accenture.academico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accenture.academico.model.ContaCorrente;
import com.accenture.academico.model.Extrato;

public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long>{

	@Query("SELECT c from CONTA c where c.numero=?1 and c.agencia=?2")
	public ContaCorrente getContaTransferencia(String numero, String agencia);
	
	@Query("SELECT c.extrato from CONTA c where c.idContaCorrente=?1")
	public List<Extrato> getExtratosConta(Long idContaCorrente);
	
	@Query("SELECT c from CONTA c where c.numero=?1")
	public ContaCorrente findByNumero(String numero);
}
