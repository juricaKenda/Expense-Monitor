package com.expenses.exceptions;

public class InvalidTransactionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Occurs when something is wrong about the transaction
	 */
	public InvalidTransactionException(String errorMessage) {
		super(errorMessage);
	}
	
}
