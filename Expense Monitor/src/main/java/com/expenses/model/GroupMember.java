package com.expenses.model;


import com.expenses.interfaces.MemberOperations;

public class GroupMember implements MemberOperations{

	private String name;
	private int id;
	private Budget budget;
	
	public GroupMember() {
		this.budget = new Budget();
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setBudget(int budgetValue) {
		this.budget = new Budget(budgetValue);
	}

	
	@Override
	public void raiseDebt(int amount) {
		this.budget.raiseDebt(amount);		
	}

	@Override
	public int cutbackDebt(int amount) {
		this.budget.cutbackDebt(amount);
		return amount;
	}
	
	/**
	 * 
	 * @return Member id for further identification
	 */
	public int getMemberId() {
		return this.id;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public int getBudget() {
		return budget.getCurrentBudget();
	}
	
	
}
