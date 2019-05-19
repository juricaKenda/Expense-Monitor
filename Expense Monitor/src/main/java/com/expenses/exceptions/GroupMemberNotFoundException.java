package com.expenses.exceptions;

public class GroupMemberNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GroupMemberNotFoundException(String errorMessage) {
		super(errorMessage);
	}
	
}
