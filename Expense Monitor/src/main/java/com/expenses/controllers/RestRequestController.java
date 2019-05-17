package com.expenses.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.expenses.mockrepository.MemberRepository;
import com.expenses.model.GroupMember;
import com.expenses.model.Transaction;
import com.expenses.service.Service;

@Controller
public class RestRequestController {
	
	
	private Service expenseService = new Service();
	
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
		model.addAttribute("membersrepo", memberRepo.getRepository().values());
		model.addAttribute("member", new GroupMember());
		
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
		model.addAttribute("membersrepo", memberRepo.getRepository().values());
		model.addAttribute("member", new GroupMember());
		return "welcomepage";
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
		model.addAttribute("allTransactions", this.expenseService.getAllTransactions());
		model.addAttribute("transaction", new Transaction());
		model.addAttribute("membersrepo",memberRepo.getRepository().values());
		
		//html located in templates folder of the project
		return "transactions";
	}
	
	
	@PostMapping("/transactions")
	public String addTransaction(Model model, @ModelAttribute Transaction transaction) {
		
		//Service performs the money transfer
		this.expenseService.performTransaction(transaction);
		
		MemberRepository memberRepo = this.expenseService.getRepository();
		
		//The rest is same setup as get mapping
		model.addAttribute("allTransactions", this.expenseService.getAllTransactions());
		model.addAttribute("transaction", new Transaction());
		model.addAttribute("membersrepo",memberRepo.getRepository().values());
		
		return "transactions";
	}
	
}
