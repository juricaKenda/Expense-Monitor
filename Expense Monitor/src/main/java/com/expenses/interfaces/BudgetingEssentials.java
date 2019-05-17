package com.expenses.interfaces;

public interface BudgetingEssentials {

	/**
	 * Decreases the balance of a member
	 * @param amount in which the balance will be affected
	 * @return true if the cutback was successful, false otherwise
	 */
	boolean cutback(int amount);
	
	
	/**
	 * Increases the balance of a member
	 * @param amount in which the balance will be affected
	 * @return true if the raise was successful, false otherwise
	 */
	boolean raise(int amount);
}
