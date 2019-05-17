package com.expenses.interfaces;

import java.util.List;

import org.springframework.stereotype.Component;

import com.expenses.mockrepository.MemberRepository;
import com.expenses.model.Transaction;

@Component
public interface ServiceEssentials {

	/**
	 * Calls the ID generator which produces a new ID
	 * @return a unique ID
	 */
	int assignUniqueId();
	
	/**
	 * Transfers the money from one member to another
	 */
	void performTransaction(Transaction transaction);
	
	/**
	 * 
	 * @return a list of all transactions
	 */
	List<Transaction> getAllTransactions();
	
	/**
	 * 
	 * @return the repository containing all members
	 */
	MemberRepository getRepository();
}
