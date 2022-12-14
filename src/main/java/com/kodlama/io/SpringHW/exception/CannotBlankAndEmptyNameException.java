package com.kodlama.io.SpringHW.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Programming Language Cannot be Empty.")
public class CannotBlankAndEmptyNameException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CannotBlankAndEmptyNameException() {
		super();
	}
	
	public CannotBlankAndEmptyNameException(String message) {
		super(message);
	}

}
