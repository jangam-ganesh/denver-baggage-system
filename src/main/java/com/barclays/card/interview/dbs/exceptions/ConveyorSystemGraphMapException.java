package com.barclays.card.interview.dbs.exceptions;

public class ConveyorSystemGraphMapException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConveyorSystemGraphMapException() {
		super();
	}
	
	public ConveyorSystemGraphMapException(String message) {
		super(message);
	}
	
	public ConveyorSystemGraphMapException(String message,Throwable ex) {
		super(message,ex);
	}
}
