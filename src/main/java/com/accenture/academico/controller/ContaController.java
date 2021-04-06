package com.accenture.academico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.academico.dto.ContaDTO;
import com.accenture.academico.dto.SaldoDTO;
import com.accenture.academico.model.ContaCorrente;
import com.accenture.academico.model.Extrato;
import com.accenture.academico.service.ContaService;



@RestController
@RequestMapping(value = "/conta")
public class ContaController {
	
	@Autowired
	ContaService service;
	


	@GetMapping(value = "/extrato") 
	public ResponseEntity<?> mostrarExtrato(@RequestParam("contaId") String id) {
		List<Extrato> extratos = service.extratosConta(id);
		return ResponseEntity.ok().body(extratos);
		
	}
	
	@PostMapping(value = "/cadastro")
	public ResponseEntity<?> cadastroConta(@RequestBody  ContaDTO conta) {
		ContaCorrente cc = service.contaFromDTO(conta);
		service.cadastroConta(cc);
		return ResponseEntity.ok().body(cc);
	}

	@PutMapping(value = "/atualizarsaldo/{id}")
    public ResponseEntity<?> atualizaSaldo(@PathVariable String id, @RequestBody SaldoDTO valor) {
	   ContaCorrente cc = service.buscaContaID(id);
	   service.atualizaSaldo(cc, valor.getValor());
	   service.cadastroConta(cc);
	   return ResponseEntity.ok().body(cc);
	}
}