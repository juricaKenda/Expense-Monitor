package com.expenses.exceptions;

public class RepositoryNotInstantiatedException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Occurs when a component tries to access uninstantiated repository
	 */
	public RepositoryNotInstantiatedException(String errorMessage) {
		super(errorMessage);
	}
	

}
