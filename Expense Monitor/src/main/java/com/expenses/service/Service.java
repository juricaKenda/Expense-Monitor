package com.expenses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.expenses.exceptions.ErrorMessages;
import com.expenses.exceptions.GroupMemberNotFoundException;
import com.expenses.exceptions.InvalidTransactionException;
import com.expenses.interfaces.ServiceEssentials;
import com.expenses.mockrepository.MemberRepository;
import com.expenses.model.GroupMember;
import com.expenses.model.Transaction;

@Component
public class Service implements ServiceEssentials{

	@Autowired
	private MemberRepository memberRepo; //Repository for all members in a group
	@Autowired
	private GroupMemberIDgenerator generator; //ID generator used while creating each member
	@Autowired
	private TransactionLog transactionLog;
	
	public Service() {
		
	}
	
	public Service(MemberRepository memberRepo, GroupMemberIDgenerator generator, TransactionLog transactionLog) {
		this.memberRepo = memberRepo;
		this.generator = generator;
		this.transactionLog = transactionLog;
	}

	@Override
	public int assignUniqueId() {
		return generator.generateId();
	}

	@Override
	public void performTransaction(Transaction transaction) throws InvalidTransactionException {
		
		try {
			/*
			 * Transaction from one sender to himself is invalid by default
			 * and it is redundant to make any repository requests for it 
			 */
			if(transaction.getSenderID() == transaction.getReceiverID()) {
				throw new InvalidTransactionException(ErrorMessages.INVALID_TRANSACTION_MESSAGE);
			}
			
			//Find the sender and receiver and perform the transaction
			GroupMember sender = this.memberRepo.getMemberById(transaction.getSenderID());
			GroupMember receiver = this.memberRepo.getMemberById(transaction.getReceiverID());
			receiver.receiveMoney(sender.sendMoney(transaction.getTransactionAmount()));
			
			//Log the transaction
			this.transactionLog.log(transaction);
			
		} catch (GroupMemberNotFoundException | InvalidTransactionException e) {
			//TODO Log the error and forward it
			throw new InvalidTransactionException(ErrorMessages.INVALID_TRANSACTION_MESSAGE);
		}
		
	}

	@Override
	public List<Transaction> getAllTransactions() {
		return (List<Transaction>)this.transactionLog.getAllTransactions();
	}

	
	@Override
	public MemberRepository getRepository() {
		return this.memberRepo;
	}


	public void setRepository(MemberRepository memberRepo) {
		this.memberRepo = memberRepo;
	}

	public TransactionLog getTransactionLog() {
		return transactionLog;
	}

	public void setTransactionLog(TransactionLog transactionLog) {
		this.transactionLog = transactionLog;
	}

	
	
	
	
}
