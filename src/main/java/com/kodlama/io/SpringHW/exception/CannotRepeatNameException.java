package com.kodlama.io.SpringHW.exception;

public class CannotRepeatNameException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CannotRepeatNameException() {
		super();
	}

	public CannotRepeatNameException(String message) {
		super(message);
	}
}
