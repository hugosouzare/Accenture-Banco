package com.accenture.academico.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.accenture.academico.dto.ContaDTO;
import com.accenture.academico.dto.MensagemDTO;
import com.accenture.academico.dto.OperacaoDTO;
import com.accenture.academico.dto.OperacaoSucedidaDTO;
import com.accenture.academico.dto.TransferenciaDTO;
import com.accenture.academico.enums.Operacao;
import com.accenture.academico.exceptions.CadastroException;
import com.accenture.academico.exceptions.TransferenciaException;
import com.accenture.academico.exceptions.ValorException;
import com.accenture.academico.model.Cliente;
import com.accenture.academico.model.ContaCorrente;
import com.accenture.academico.model.Extrato;
import com.accenture.academico.repository.ClienteRepository;
import com.accenture.academico.repository.ContaCorrenteRepository;

@Service
public class ContaService {

	@Autowired
	ContaCorrenteRepository contarepo;

	@Autowired
	ExtratoService extservice;

	@Autowired
	ClienteRepository clirepo;

	public void cadastroConta(ContaCorrente conta) throws CadastroException {

		if (conta.getNumero() == null) {
			throw new CadastroException("Erro ao cadastrar, numero da conta não pode estar vazio");
		}

		if (contarepo.findByNumero(conta.getNumero()) != null) {
			throw new CadastroException("Número da conta ja existe!");
		}
		contarepo.save(conta);
	}

	public void transferencia(TransferenciaDTO transf) throws TransferenciaException {

		BigDecimal c = new BigDecimal(0);

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
		ContaCorrente contadestino = contarepo.getContaTransferencia(transf.getContaDestino(),
				transf.getAgenciaDestino());

		if (contadestino == null) {
			throw new TransferenciaException(
					"A conta destino não foi encontrada, favor informe os parametros corretos");
		}

		if (transf.getValor().compareTo(cc.getSaldo()) == 1) {
			throw new TransferenciaException(
					"TRANSFERÊNCIA NÃO REALIZADA! Valor da transferência excede o saldo da conta de origem");
		}

		if (transf.getValor().compareTo(c) <= 0) {
			throw new TransferenciaException("Valor da transferência precisa ser maior que 0");
		}

		cc.setSaldo(cc.getSaldo().subtract(transf.getValor()));
		contadestino.setSaldo(contadestino.getSaldo().add(transf.getValor(), MathContext.DECIMAL32));

		Extrato ext1 = new Extrato();
		ext1.setConta(cc);
		ext1.setDataHoraMovimento(null);
		ext1.setOperacao(Operacao.TRANSFERENCIAENVIADA.getDescricao());
		ext1.setValorOperacao(ext1.getValorOperacao().subtract(transf.getValor()));

		Extrato ext2 = new Extrato();
		ext2.setConta(contadestino);
		ext2.setDataHoraMovimento(null);
		ext2.setOperacao(Operacao.TRANSFERENCIARECEBIDA.getDescricao());
		ext2.setValorOperacao(transf.getValor());

		extservice.salvarExtrato(ext1);
		extservice.salvarExtrato(ext2);

	}

	public ContaCorrente contaFromDTO(ContaDTO conta) throws CadastroException {
		ContaCorrente cc = new ContaCorrente();

		if (!clirepo.existsById(conta.getIdCliente())) {
			throw new TransferenciaException("CONTA NÃO CADASTRADA! Cliente não encontrado");
		}

		Cliente cli = clirepo.findById(conta.getIdCliente()).orElseThrow();

		cc.setAgencia("0" + cli.getAgencia().getIdAgencia().toString());
		cc.setNumero(conta.getContaNumero());
		cc.setSaldo(conta.getSaldo());
		cc.setCliente(cli);

		cli.getContacorrente().add(cc);

		return cc;
	}

	public ContaCorrente buscaContaID(String val) {

		Long id = Long.parseLong(val);
		ContaCorrente conta = contarepo.findById(id).orElseThrow();

		return conta;
	}

	public void atualizaSaldo(ContaCorrente conta, BigDecimal valor) {
		conta.setSaldo(valor);
	}

	public List<Extrato> extratosConta(String id) {
		Long id1 = Long.parseLong(id);
		List<Extrato> extratos = contarepo.getExtratosConta(id1);
		return extratos;
	}

	public MensagemDTO mensagemTransferenciaOK(TransferenciaDTO transf) {
		Calendar cal = new GregorianCalendar();
		ContaCorrente cli = contarepo.findById(transf.getIdConta()).orElseThrow();

		ContaCorrente contadestino = contarepo.getContaTransferencia(transf.getContaDestino(),
				transf.getAgenciaDestino());
		String mensagem = "Transferência enviada com sucesso!";

		MensagemDTO msg = new MensagemDTO(HttpStatus.OK.value(), mensagem, transf.getValor(), cal.getTime(),
				cli.getCliente().getNome(), contadestino.getCliente().getNome());

		return msg;
	}

	public OperacaoSucedidaDTO operacao(OperacaoDTO dto) throws ValorException {
		ContaCorrente cc = contarepo.findById(dto.getContaId()).orElseThrow();
		Extrato ext = new Extrato();

		ext.setOperacao(Operacao.toEnum(dto.getOperacao()).getDescricao());
		ext.setValorOperacao(dto.getValor());

		ext.setConta(cc);

		Calendar cal = new GregorianCalendar();

		switch (dto.getOperacao()) {
		case 1:
			if (dto.getValor().compareTo(cc.getSaldo()) == 1) {
				throw new ValorException("ERRO! Valor do saque excede o saldo da conta");
			}
			cc.setSaldo(cc.getSaldo().subtract(dto.getValor()));

			break;
		case 2:
			cc.setSaldo(cc.getSaldo().add(dto.getValor()));
			break;
		default:
			throw new ValorException("OPERAÇÃO INVÁLIDA! 1 para saque e 2 para depósito");

		}

		extservice.salvarExtrato(ext);

		String mssg = Operacao.toEnum(dto.getOperacao()).getDescricao() + " realizado com sucesso!";

		OperacaoSucedidaDTO msg = new OperacaoSucedidaDTO(HttpStatus.OK.value(), mssg, cal.getTime(), dto.getValor(),
				cc.getSaldo());
		return msg;
	}
}
