package com.accenture.academico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.academico.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
