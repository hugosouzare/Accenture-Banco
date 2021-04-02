package com.accenture.academico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.academico.repository.ContaCorrenteRepository;

@Service
public class ContaService {

	@Autowired
	ContaCorrenteRepository contarepo;

	 
}
