package com.barclays.card.interview.dbs.exceptions;

public class InvalidInputDataException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidInputDataException() {
		super();
	}
	
	public InvalidInputDataException(String message) {
		super(message);
	}
	
	public InvalidInputDataException(String message,Throwable ex) {
		super(message,ex);
	}

}
