package com.accenture.academico.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> insert(@RequestBody @Valid ClienteDTO cliente) {
		Cliente cli = service.fromDTO(cliente);
        service.salvarCliente(cli);
        return ResponseEntity.ok().body(cli);
	}
	
	
}