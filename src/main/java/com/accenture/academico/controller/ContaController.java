package com.accenture.academico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.academico.dto.ContaDTO;
import com.accenture.academico.model.ContaCorrente;
import com.accenture.academico.service.ContaService;

@RestController
@RequestMapping(value = "/conta")
public class ContaController {
	
	@Autowired
	ContaService service;

	@PostMapping(value = "/cadastro")
	public void cadastroConta(@RequestBody  ContaDTO conta) {
		ContaCorrente cc = service.contaFromDTO(conta);
		service.cadastroConta(cc);
	}
	
}
