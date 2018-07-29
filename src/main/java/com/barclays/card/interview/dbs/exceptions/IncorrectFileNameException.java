package com.barclays.card.interview.dbs.exceptions;

public class IncorrectFileNameException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IncorrectFileNameException() {
		super();
	}
	
	public IncorrectFileNameException(String message) {
		super(message);
	}
	
	public IncorrectFileNameException(String message,Throwable ex) {
		super(message,ex);
	}
	
}
