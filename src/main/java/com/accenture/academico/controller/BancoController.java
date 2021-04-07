package com.accenture.academico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.academico.dto.MensagemDTO;
import com.accenture.academico.dto.TransferenciaDTO;
import com.accenture.academico.service.ContaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/banco")
@Api(value="Operações Bancárias")
public class BancoController {
	
	@Autowired
	ContaService service;

	@ApiOperation(value="Transfere valores entre contas")
	@PostMapping(value = "/transferencia")
	public ResponseEntity<?> transferencia(@RequestBody  TransferenciaDTO transf) {
		service.transferencia(transf);
		MensagemDTO msg = service.mensagemTransferenciaOK(transf);
		return ResponseEntity.ok().body(msg);
	}
	

}
