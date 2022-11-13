package com.kodlama.io.SpringHW.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CannotRepeatNameException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CannotRepeatNameException() {
		super();
	}

	public CannotRepeatNameException(String message) {
		super(message);
	}
}
