package com.expenses.model;

public class Transaction {

	private int senderID,receiverID;
	private int transactionAmount;
	
	
	public Transaction() {
		
	}
	
	public Transaction(int sender, int receiver, int transactionAmount) {
		this.senderID = sender;
		this.receiverID = receiver;
		this.transactionAmount = transactionAmount;
	}

	public int getSenderID() {
		return senderID;
	}

	public void setSenderID(int sender) {
		this.senderID = sender;
	}

	public int getReceiverID() {
		return receiverID;
	}

	public void setReceiverID(int receiver) {
		this.receiverID = receiver;
	}

	public int getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	
	
	
}
