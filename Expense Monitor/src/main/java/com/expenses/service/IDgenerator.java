package com.expenses.service;

public class IDgenerator {

	private int idCount = 0;
	
	public int generateId() {
		return this.idCount++;
	}
	
}
