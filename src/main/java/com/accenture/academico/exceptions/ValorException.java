package com.accenture.academico.exceptions;

public class ValorException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	public ValorException(String message) {
		super(message);
	}
	
	public ValorException(String message, Throwable cause) {
		super(message, cause);
	}
}
