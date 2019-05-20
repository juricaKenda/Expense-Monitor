package com.expenses.exceptions;

public class GroupMemberNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Occurs when a member with a given ID is not found in the repository
	 */
	public GroupMemberNotFoundException(String errorMessage) {
		super(errorMessage);
	}
	
}
