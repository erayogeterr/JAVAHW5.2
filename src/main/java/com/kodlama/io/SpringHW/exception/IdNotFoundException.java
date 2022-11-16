package com.kodlama.io.SpringHW.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND , reason = "There is no programming language registered to this id number.")
public class IdNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public IdNotFoundException() {
		super();
	}
	
	public IdNotFoundException(String message) {
		super(message);
	}
	

}
