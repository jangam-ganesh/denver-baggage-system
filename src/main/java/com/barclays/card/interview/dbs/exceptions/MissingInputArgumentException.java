package com.barclays.card.interview.dbs.exceptions;

public class MissingInputArgumentException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MissingInputArgumentException() {
		super();
	}
	
	public MissingInputArgumentException(String message) {
		super(message);
	}
	
	public MissingInputArgumentException(String message,Throwable ex) {
		super(message,ex);
	}
	
}
