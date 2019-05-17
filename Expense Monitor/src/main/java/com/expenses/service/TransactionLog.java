package com.expenses.service;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.expenses.model.Transaction;

@Component
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
