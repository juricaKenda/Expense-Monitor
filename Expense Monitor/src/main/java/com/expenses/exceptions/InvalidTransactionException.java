package com.expenses.exceptions;

public class InvalidTransactionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidTransactionException(String errorMessage) {
		super(errorMessage);
	}
	
}
