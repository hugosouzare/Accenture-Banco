package com.accenture.academico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.academico.dto.DeleteDTO;
import com.accenture.academico.model.Agencia;
import com.accenture.academico.service.AgenciaService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/agencia")
public class AgenciaController {

	@Autowired
	AgenciaService service;
	
	@ApiOperation(value="Cadastra uma agencia")
	@PostMapping(value = "/cadastro")
	public ResponseEntity<?> cadastro(@RequestBody Agencia agencia) {
		service.salvarAgencia(agencia);
		return ResponseEntity.ok().body(agencia);
	}
	
	@ApiOperation(value="Busca uma agencia por ID")
	@GetMapping(value = "/busca/{id}")
	public ResponseEntity<?> busca(@PathVariable String id) {
		Agencia ag = service.buscaAgencia(id);
		return ResponseEntity.ok().body(ag);
	}
	
	@ApiOperation(value = "Deleta uma agencia por ID")
	@DeleteMapping(value= "/deletaagencia/{id}")
	public ResponseEntity<?> deleta( @PathVariable String id) {
		DeleteDTO msg = service.delete(id);
		return ResponseEntity.ok().body(msg);
	}
	
	@ApiOperation(value = "Atualiza uma agencia")
	@PutMapping(value = "/atualizaagencia")
	public ResponseEntity<?> atualiza(@RequestBody Agencia agencia) {
		service.salvarAgencia(agencia);
		return ResponseEntity.ok().body(agencia);
	}
}
