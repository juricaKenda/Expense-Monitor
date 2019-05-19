package com.expenses.exceptions;

public class RepositoryNotInstantiatedException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RepositoryNotInstantiatedException(String errorMessage) {
		super(errorMessage);
	}
	

}
