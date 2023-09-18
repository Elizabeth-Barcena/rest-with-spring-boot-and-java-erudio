package br.com.erudio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationException extends RuntimeException{
	
	public UnsupportedMathOperationException(String ex) {
		super(ex);
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID=1L;
	
}
