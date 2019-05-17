package com.expenses.model;

import com.expenses.interfaces.BudgetingEssentials;

public class Budget implements BudgetingEssentials{

	private int balance;

	public Budget() {
		
	}
	
	public Budget(int startingBudget) {
		this.balance = startingBudget;
	}

	@Override
	public boolean cutback(int amount) {
		this.balance -= amount;
		return true; 
		//boolean return type set for later options
		//Example : we want to forbid budgets to go above or underneath a certain limit
	}

	@Override
	public boolean raise(int amount) {
		this.balance += amount;
		return true;
	}

	/**
	 * 
	 * @return current budget of this group member
	 */
	public int getCurrentBudget() {
		return balance;
	}
	
	/**
	 * Sets the budget of this group member
	 * @param currentBudget
	 */
	public void setCurrentBudget(int currentBudget) {
		this.balance = currentBudget;
	}
	
	
	
	
}
