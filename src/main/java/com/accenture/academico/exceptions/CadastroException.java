package com.accenture.academico.exceptions;

public class CadastroException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CadastroException(String message) {
		super(message);
	}
	
	public CadastroException(String message, Throwable cause) {
		super(message, cause);
	}
}
