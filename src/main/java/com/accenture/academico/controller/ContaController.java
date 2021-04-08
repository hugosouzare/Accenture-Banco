package com.accenture.academico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.accenture.academico.dto.ContaDTO;
import com.accenture.academico.dto.MensagemDTO;
import com.accenture.academico.dto.OperacaoDTO;
import com.accenture.academico.dto.OperacaoSucedidaDTO;
import com.accenture.academico.dto.SaldoDTO;
import com.accenture.academico.dto.TransferenciaDTO;
import com.accenture.academico.model.ContaCorrente;
import com.accenture.academico.model.Extrato;
import com.accenture.academico.service.ContaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/conta")
@Api(value = "Operações envolvendo uma conta")
public class ContaController {

	@Autowired
	ContaService service;

	@ApiOperation(value = "Retorna todos os extratos de uma conta através do seu ID")
	@GetMapping(value = "/extrato")
	public ResponseEntity<?> mostrarExtrato(@RequestParam("contaId") String id) {
		List<Extrato> extratos = service.extratosConta(id);
		return ResponseEntity.ok().body(extratos);

	}

	@ApiOperation(value = "Cadastra uma conta")
	@PostMapping(value = "/cadastro")
	public ResponseEntity<?> cadastroConta(@RequestBody ContaDTO conta) {
		ContaCorrente cc = service.contaFromDTO(conta);
		service.cadastroConta(cc);
		return ResponseEntity.ok().body(cc);
	}

	@ApiOperation(value = "Modifica o saldo de uma conta para o valor inserido no campo: valor")
	@PutMapping(value = "/atualizarsaldo/{id}")
	public ResponseEntity<?> atualizaSaldo(@PathVariable String id, @RequestBody SaldoDTO valor) {
		ContaCorrente cc = service.buscaContaID(id);
		service.atualizaSaldo(cc, valor.getValor());
		service.cadastroConta(cc);
		return ResponseEntity.ok().body(cc);
	}

	@ApiOperation(value = "Transfere valores entre contas")
	@PostMapping(value = "/transferencia")
	public ResponseEntity<?> transferencia(@RequestBody TransferenciaDTO transf) {
		service.transferencia(transf);
		MensagemDTO msg = service.mensagemTransferenciaOK(transf);
		return ResponseEntity.ok().body(msg);

	}

	@ApiOperation(value = "Deposita ou saca dinheiro de uma conta de acordo com o parametro passado. 1 = Saque 2 = Depósito")
	@PostMapping(value = "/operacao")
	public ResponseEntity<?> operacao(@RequestBody OperacaoDTO dto) {
		OperacaoSucedidaDTO oper = service.operacao(dto);
		
		return ResponseEntity.ok().body(oper);

	}
}