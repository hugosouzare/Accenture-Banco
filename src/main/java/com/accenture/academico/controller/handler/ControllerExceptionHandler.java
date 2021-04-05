package com.accenture.academico.controller.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

	   @ExceptionHandler(RuntimeException.class)
	   public ResponseEntity<StandardError> cadastroException(RuntimeException c, HttpServletRequest request) {
		
		StandardError e = new StandardError(HttpStatus.NOT_FOUND.value(), c.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
	}
}
