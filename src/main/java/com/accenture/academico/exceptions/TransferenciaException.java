package com.accenture.academico.exceptions;

public class TransferenciaException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TransferenciaException(String message) {
		super(message);
	}
	
	public TransferenciaException(String message, Throwable cause) {
		super(message, cause);
	}
}
