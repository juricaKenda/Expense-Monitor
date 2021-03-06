package com.expenses.exceptions;

public class ErrorMessages {

	public static final String INVALID_TRANSACTION_DEFAULT = "Requested transaction is invalid and can not be performed!";
	public static final String INVALID_TRANSACTION_AMOUNT = "Requested transaction amount is invalid and can not be performed!";
	public static final String INVALID_TRANSACTION_REFLECTIVE = "Requested transaction is invalid! Sender and receiver are the same entity! ";
	
	
	public static final String MEMBER_NOT_FOUND_MESSAGE = "Group member with a given ID was not found in the repository!";
	
	public static final String REPOSITORY_NOT_INSTANTIATED = "Repository was not yet instantiated!";

}
