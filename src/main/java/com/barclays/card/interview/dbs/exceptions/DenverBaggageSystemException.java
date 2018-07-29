package com.barclays.card.interview.dbs.exceptions;

public class DenverBaggageSystemException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DenverBaggageSystemException() {
		super();
	}
	
	public DenverBaggageSystemException(String message) {
		super(message);
	}
	
	public DenverBaggageSystemException(String message,Throwable ex) {
		super(message,ex);
	}
}

