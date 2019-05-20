package com.expenses.model;

import com.expenses.interfaces.BudgetingEssentials;


public class Budget implements BudgetingEssentials{

	//A person is in debt = negative value
	//A person is owed money = positive value
	private int debtTowardsGroup;

	public Budget() {
		
	}
	
	public Budget(int startingBudget) {
		this.debtTowardsGroup = startingBudget;
	}

	@Override
	public boolean cutbackDebt(int amount) {
		this.debtTowardsGroup += amount;
		return true; 
		//boolean return type set for later options
		//Example : we want to forbid budgets to go above or underneath a certain limit
	}

	@Override
	public boolean raiseDebt(int amount) {
		this.debtTowardsGroup -= amount;
		return true;
	}

	/**
	 * Debt is negative if person owes money,
	 * positive if person is owed money
	 * 
	 * @return debt towards other group members
	 */
	public int getDebtTowardsGroup() {
		return debtTowardsGroup;
	}

	/**
	 * Enables user to set the members debt
	 * @param debtTowardsGroup the amount with which the account will be affected
	 */
	public void setDebtTowardsGroup(int debtTowardsGroup) {
		this.debtTowardsGroup = debtTowardsGroup;
	}


	
	
}
