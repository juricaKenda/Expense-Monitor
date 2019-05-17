package com.expenses.service;

import java.util.List;

import com.expenses.interfaces.ServiceEssentials;
import com.expenses.mockrepository.MemberRepository;
import com.expenses.model.GroupMember;
import com.expenses.model.Transaction;

public class Service implements ServiceEssentials{

	private MemberRepository memberRepo = new MemberRepository(); //Repository for all members in a group
	private IDgenerator generator = new IDgenerator(); //ID generator used while creating each member
	private TransactionLog transactionLog = new TransactionLog();
	
	@Override
	public int assignUniqueId() {
		return generator.generateId();
	}

	@Override
	public void performTransaction(Transaction transaction) {
		
		//Find the sender and receiver and perform the transaction
		GroupMember sender = this.memberRepo.getMemberById(transaction.getSenderID());
		GroupMember receiver = this.memberRepo.getMemberById(transaction.getReceiverID());
		receiver.receiveMoney(sender.sendMoney(transaction.getTransactionAmount()));
		
		//Log the transaction
		this.transactionLog.log(transaction);
	}

	@Override
	public List<Transaction> getAllTransactions() {
		return (List<Transaction>)this.transactionLog.getAllTransactions();
	}

	
	@Override
	public MemberRepository getRepository() {
		return this.memberRepo;
	}
	
	
	
	
}
