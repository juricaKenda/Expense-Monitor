package com.expenses.model;

public class Budget implements BudgetingEssentials{

	private int currentBudget;

	public Budget(int startingBudget) {
		this.currentBudget = startingBudget;
	}

	@Override
	public boolean cutback(int amount) {
		this.currentBudget -= amount;
		return true; //boolean return type set for later options
		// Example : we want to forbid budgets to go above or underneath a certain limit
	}

	@Override
	public boolean raise(int amount) {
		this.currentBudget += amount;
		return true;
	}
	
	
}
