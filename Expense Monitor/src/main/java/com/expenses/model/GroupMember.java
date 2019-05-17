package com.expenses.model;

public class GroupMember implements MemberOperations{

	private String name;
	private int id;
	private Budget budget;
	
	/**
	 * Creates a new group member instance
	 * @param name - name of the member
	 * @param id - id assigned by the generator
	 * @param initialBudget - starting budget of this member
	 */
	public GroupMember(String name, int id, int initialBudget) {
		this.name = name;
		this.id = id;
		this.budget = new Budget(initialBudget);
	}

	@Override
	public void receiveMoney(int amount) {
		this.budget.raise(amount);		
	}

	@Override
	public int sendMoney(int amount) {
		this.budget.cutback(amount);
		return amount;
	}
	
	
	
}
