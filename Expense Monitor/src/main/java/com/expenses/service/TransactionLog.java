package com.expenses.service;

import java.util.ArrayList;

import com.expenses.model.Transaction;

public class TransactionLog {

	private ArrayList<Transaction> allTransactions;
	
	public TransactionLog() {
		this.allTransactions = new ArrayList<Transaction>();
	}
	
	public void log(Transaction transaction) {
		this.allTransactions.add(transaction);
	}
	
	public ArrayList<Transaction> getAllTransactions(){
		return this.allTransactions;
	}
}
