package com.accenture.academico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.academico.dto.TransferenciaDTO;
import com.accenture.academico.service.ContaService;

@RestController
@RequestMapping(value = "/banco")
public class BancoController {
	
	@Autowired
	ContaService service;

	@PostMapping(value = "/transferencia")
	public void transferencia(@RequestBody  TransferenciaDTO transf) {
		service.transferencia(transf);
	}
	

}
