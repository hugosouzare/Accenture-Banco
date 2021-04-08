package com.accenture.academico.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.academico.dto.ClienteDTO;
import com.accenture.academico.dto.DeleteDTO;
import com.accenture.academico.dto.GetClienteDTO;
import com.accenture.academico.model.Cliente;
import com.accenture.academico.service.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/cliente")
@Api(value="Operações envolvendo cliente")
public class ClienteController {

	@Autowired
	ClienteService service;

	@ApiOperation(value="Cadastra um cliente")
	@PostMapping(value = "/criarcliente")
	public ResponseEntity<?> insert(@RequestBody @Valid ClienteDTO cliente) {
		Cliente cli = service.fromDTO(cliente);
        service.salvarCliente(cli);
        return ResponseEntity.ok().body(cli);
	}
	
	@ApiOperation(value = "Deleta um cliente por ID")
	@DeleteMapping(value= "/deletacliente/{id}")
	public ResponseEntity<?> deletaCliente( @PathVariable String id) {
		DeleteDTO msg = service.delete(id);
		return ResponseEntity.ok().body(msg);
	}
	
	@ApiOperation(value = "Busca cliente por ID")
	@GetMapping(value= "/buscacliente/{id}")
	public ResponseEntity<?> buscaCliente( @PathVariable String id) {
		GetClienteDTO cli = service.buscaCliente(id);
		return ResponseEntity.ok().body(cli);
	}
	
}