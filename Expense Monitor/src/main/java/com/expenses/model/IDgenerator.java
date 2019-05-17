package com.expenses.model;

public class IDgenerator {

	private int idCount = 0;
	
	public int generateId() {
		return this.idCount++;
	}
	
}
