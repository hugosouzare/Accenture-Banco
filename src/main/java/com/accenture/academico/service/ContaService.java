package com.accenture.academico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.academico.dto.TransferenciaDTO;
import com.accenture.academico.enums.Operacao;
import com.accenture.academico.exceptions.CadastroException;
import com.accenture.academico.exceptions.TransferenciaException;
import com.accenture.academico.model.ContaCorrente;
import com.accenture.academico.model.Extrato;
import com.accenture.academico.repository.ContaCorrenteRepository;

@Service
public class ContaService {

	@Autowired
	ContaCorrenteRepository contarepo;

	@Autowired
	ExtratoService extservice;
	
	public void cadastroConta(ContaCorrente conta) throws CadastroException {

		if (conta.getNumero() == null) {
			throw new CadastroException("Erro ao cadastrar, numero da conta não pode estar vazio");
		}
		contarepo.save(conta);
	}

	public void transferencia(TransferenciaDTO transf) throws TransferenciaException {

		if (!contarepo.existsById(transf.getIdConta())) {
			throw new TransferenciaException("ID Da conta de origem não existe no banco de dados");
		}
		
		ContaCorrente cc = contarepo.findById(transf.getIdConta()).orElseThrow();
		
		if (transf.getContaDestino() == null) {
			throw new TransferenciaException("CAMPO OBRIGATÓRIO: contaDestino");
		}
		
		if (transf.getAgenciaDestino() == null) {
			throw new TransferenciaException("CAMPO OBRIGATÓRIO: agenciaDestino");
		}
		ContaCorrente contadestino =  contarepo.getContaTransferencia(transf.getContaDestino(), transf.getAgenciaDestino());
		
		if (contadestino == null) {
			throw new TransferenciaException("A conta destino não foi encontrada, favor informe os parametros corretos");
		}
		
		if (transf.getValor() > cc.getSaldo()) {
			throw new TransferenciaException("TRANSFERÊNCIA NÃO REALIZADA! Valor da transferência excede o saldo da conta de origem");
		}
		
		if (transf.getValor() <= 0) {
			throw new TransferenciaException("Valor da transferência precisa ser maior que 0");
		}
		
		cc.setSaldo(cc.getSaldo()-transf.getValor());
		contadestino.setSaldo(contadestino.getSaldo()+transf.getValor());
		
		
		Extrato ext1 = new Extrato();
		ext1.setConta(cc);
		ext1.setDataHoraMovimento(null);
		ext1.setOperacao(Operacao.TRANSFERENCIAENVIADA.getDescricao());
		ext1.setValorOperacao(-transf.getValor());
		
		
		Extrato ext2 = new Extrato();
		ext2.setConta(contadestino);
		ext2.setDataHoraMovimento(null);
		ext2.setOperacao(Operacao.TRANSFERENCIARECEBIDA.getDescricao());
		ext2.setValorOperacao(transf.getValor());
		
		extservice.salvarExtrato(ext1);
		extservice.salvarExtrato(ext2);
		
	}
}
