package com.expenses.interfaces;

public interface MemberEssentials {

	/**
	 * Performs a transaction in which this group member receives money
	 * @param amount quantity that the member receives
	 */
	public void raiseDebt(int amount);
	
	/**
	 * Performs a transaction in which this group member gives away his money
	 * @param amount quantity that the member gives
	 * @return quantity that the member gives
	 */
	public int cutbackDebt(int amount);
}
