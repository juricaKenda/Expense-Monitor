package com.expenses.service;

import org.springframework.stereotype.Component;

@Component
public class GroupMemberIDgenerator {

	private int idCount = 0;
	
	public int generateId() {
		return this.idCount++;
	}
	
}
