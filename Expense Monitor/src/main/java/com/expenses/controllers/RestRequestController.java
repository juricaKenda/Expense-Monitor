package com.expenses.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.expenses.exceptions.GroupMemberNotFoundException;
import com.expenses.exceptions.InvalidTransactionException;
import com.expenses.exceptions.RepositoryNotInstantiatedException;
import com.expenses.mockrepository.MemberRepository;
import com.expenses.model.GroupMember;
import com.expenses.model.Transaction;
import com.expenses.service.ExpenseService;

@Controller
public class RestRequestController {
	
	@Autowired
	private ExpenseService expenseService;

	private static final Logger LOGGER = LoggerFactory.getLogger(RestRequestController.class);
	
	public RestRequestController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}


	/**
	 * Displays a home page and adds attributes to the model of the page
	 * @param model a holder for model attributes
	 * @return html file for presenting the data and input forms
	 */
	@GetMapping("/home")
	public String welcomePage(Model model) {
		
		//Controller requests a link to the repository instance from the service
		MemberRepository memberRepo = this.expenseService.getRepository();
		
		//Adding member repository for saving members and a new member instance
		try {
			model.addAttribute("membersrepo", memberRepo.getRepository().values());
			model.addAttribute("member", new GroupMember());
		} catch (RepositoryNotInstantiatedException e) {
			//Log the error
			LOGGER.error(e.getMessage());
		}
		//html located in templates folder of the project
		return "welcomepage";
	}
	
	
	@PostMapping("/home")
	public String addMember(Model model, @ModelAttribute GroupMember member) {
		
		MemberRepository memberRepo = this.expenseService.getRepository();
		
		/*
		 * Since the member name and starting budget are user defined,
		 * we are only left with the task of assigning a unique id
		 */
		member.setId(expenseService.assignUniqueId());
		memberRepo.addGroupMember(member);
		
		//The rest is same setup as get mapping
		try {
			model.addAttribute("membersrepo", memberRepo.getRepository().values());
			model.addAttribute("member", new GroupMember());
		} catch (RepositoryNotInstantiatedException e) {
			// Log the error
			LOGGER.error(e.getMessage());
		}
		
		return "welcomepage";
	}
	
	//BAD PRACTICE ALERT - deleting with a get mapping
	@GetMapping("/deleteMember/{id}")
	public String deleteById(@PathVariable int id) {
		
		MemberRepository memberRepo = this.expenseService.getRepository();
		try {
			if(memberRepo.deleteMemberById(id)) {
				return "deleteSuccessful";
			}
		} catch (GroupMemberNotFoundException e) {
			// Log the error
			LOGGER.error(e.getMessage());
		}
		return "deleteUnsuccessful";
	}
	
	//BAD PRACTICE ALERT - deleting with a get mapping
	@GetMapping("/deleteAll")
	public String deleteAll() {
		
		MemberRepository memberRepo = this.expenseService.getRepository();
		memberRepo.clearRepository();
		return "clearedAllPage";
	}
	
	
	/**
	 * Returns the page where user is redirected after pressing redirect link on welcome page
	 * @param model a holder for model attributes
	 * @return transaction html page
	 */
	@GetMapping("/transactions")
	public String transactionsPage(Model model) {
	
		//We want to display all members for easier use
		MemberRepository memberRepo = this.expenseService.getRepository();
		
		/*
		 * Adding transaction log for displaying transactions,
		 * all group members 
		 * and a new transaction instance
		 */	
		try {
			model.addAttribute("allTransactions", this.expenseService.getAllTransactions());
			model.addAttribute("transaction", new Transaction());
			model.addAttribute("membersrepo", memberRepo.getRepository().values());
			
		} catch (RepositoryNotInstantiatedException e) {
			//Log the error
			LOGGER.error(e.getMessage());
		}
		
		//html located in templates folder of the project
		return "transactions";
	}
	
	
	@PostMapping("/transactions")
	public String addTransaction(Model model, @ModelAttribute Transaction transaction) {
		
		
		try {
			//Service performs the money transfer
			this.expenseService.performTransaction(transaction);
			
		} catch (InvalidTransactionException e) {
			//TODO let user know the transaction went wrong
			//Log the error
			LOGGER.error(e.getMessage());
		}
		
		//Enable the model make future transactions
		MemberRepository memberRepo = this.expenseService.getRepository();
		
		//The rest is same setup as get mapping
		try {
			model.addAttribute("allTransactions", this.expenseService.getAllTransactions());
			model.addAttribute("transaction", new Transaction());
			model.addAttribute("membersrepo", memberRepo.getRepository().values());
			
		} catch (RepositoryNotInstantiatedException e) {
			//Log the error
			LOGGER.error(e.getMessage());
		}
		
		return "transactions";
	}
	
}
