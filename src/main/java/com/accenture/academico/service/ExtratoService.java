package com.accenture.academico.service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.academico.exceptions.CadastroException;
import com.accenture.academico.model.Extrato;
import com.accenture.academico.repository.ExtratoRepository;

@Service
public class ExtratoService {

	@Autowired
	ExtratoRepository extratoRepository;

	public void salvarExtrato(Extrato extrato) throws CadastroException {

		if (extrato.getDataHoraMovimento() == null) {
			Calendar cal = new GregorianCalendar();

			extrato.setDataHoraMovimento(cal.getTime());
		}

		extratoRepository.save(extrato);
	}
	
	
}
