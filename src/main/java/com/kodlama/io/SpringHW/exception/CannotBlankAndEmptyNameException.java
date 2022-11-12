package com.kodlama.io.SpringHW.exception;

public class CannotBlankAndEmptyNameException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CannotBlankAndEmptyNameException() {
		super();
	}
	
	public CannotBlankAndEmptyNameException(String message) {
		super(message);
	}

}
