package com.accenture.academico.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.academico.dto.ClienteDTO;
import com.accenture.academico.model.Cliente;
import com.accenture.academico.service.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

	@Autowired
	ClienteService service;

	@PostMapping(value = "/criarcliente")
	public void insert(@RequestBody @Valid ClienteDTO cliente) {
		Cliente cli = service.fromDTO(cliente);
        service.salvarCliente(cli);
	}
}