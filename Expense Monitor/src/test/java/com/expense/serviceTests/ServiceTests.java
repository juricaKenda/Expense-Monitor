package com.expense.serviceTests;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.expenses.exceptions.InvalidTransactionException;
import com.expenses.mockrepository.MemberRepository;
import com.expenses.model.GroupMember;
import com.expenses.model.Transaction;
import com.expenses.service.ExpenseService;
import com.expenses.service.TransactionLog;

public class ServiceTests {

	private static ExpenseService serviceInstance;
	
	
	@BeforeClass
	public static void setup() {
		serviceInstance = new ExpenseService();
		serviceInstance.setRepository(new MemberRepository());
		serviceInstance.setTransactionLog(new TransactionLog());
	}
	
	
	/**
	 * This test ensures that senders balance was cutback
	 * and the receivers balance was incremented by the same amount
	 * @throws InvalidTransactionException 
	 */
	@Test
	public void performTransactionTest() throws InvalidTransactionException {
		
		//Prepare the components for test case
		GroupMember sender = new GroupMember();
		sender.setId(ServiceTestConstants.mockedSenderID);
		sender.setBudget(ServiceTestConstants.mockedSenderStartBalance);
		
		GroupMember receiver = new GroupMember();
		receiver.setId(ServiceTestConstants.mockedReceiverID);
		receiver.setBudget(ServiceTestConstants.mockedReceiverStartBalance);
		
		MemberRepository mockRepository = serviceInstance.getRepository();
		mockRepository.addGroupMember(sender);
		mockRepository.addGroupMember(receiver);
		
		Transaction transaction = new Transaction(sender.getId(), receiver.getId(), ServiceTestConstants.mockedTransactionAmount);
		
		//Perform the transaction
		serviceInstance.performTransaction(transaction);
	
		
		//Inspect the result
		assertEquals(sender.getBudget(),ServiceTestConstants.mockedSenderStartBalance + transaction.getTransactionAmount());
		assertEquals(receiver.getBudget(),ServiceTestConstants.mockedReceiverStartBalance - transaction.getTransactionAmount());
		
	}
	
	
	/**
	 * Tests if a certainly invalid transaction will throw a proper exception
	 * @throws InvalidTransactionException
	 */
	@Test(expected = InvalidTransactionException.class)
	public void testInvalidTransactionException() throws InvalidTransactionException {
	
		//No import of sender and receiver
		Transaction transaction = new Transaction(ServiceTestConstants.unsavedSenderID, ServiceTestConstants.unsavedReceiverID, ServiceTestConstants.mockedTransactionAmount);
		serviceInstance.performTransaction(transaction);
	}
	
	/**
	 * Transaction log size should linearly follow
	 * the amount of transactions performed
	 * @throws InvalidTransactionException 
	 */
	@Test
	public void getAllTransactionsTest() throws InvalidTransactionException {
		performTransactionTest();
		assertEquals(serviceInstance.getAllTransactions().size(),1);
		
		serviceInstance.getAllTransactions().clear();
		assertEquals(serviceInstance.getAllTransactions().size(),0);
	}
	
}
