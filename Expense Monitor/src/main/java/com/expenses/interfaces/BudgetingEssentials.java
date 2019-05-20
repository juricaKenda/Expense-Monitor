package com.expenses.interfaces;

public interface BudgetingEssentials {

	/**
	 * Decreases the debt of a member towards other group members
	 * @param amount in which the debt will be affected
	 * @return true if the cutback was successful, false otherwise
	 */
	boolean cutbackDebt(int amount);
	
	
	/**
	 * Increases the debt of a member
	 * @param amount in which the debt will be affected
	 * @return true if the raise was successful, false otherwise
	 */
	boolean raiseDebt(int amount);
}
