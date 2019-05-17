package com.expenses.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.expenses.mockrepository.MemberRepository;
import com.expenses.model.GroupMember;
import com.expenses.model.IDgenerator;

@Controller
public class RestRequestController {
	
	private MemberRepository memberRepo = new MemberRepository(); //Repository for all members in a group
	private IDgenerator generator = new IDgenerator(); //ID generator used while creating each member
	
	/**
	 * Displays a home page and adds attributes to the model of the page
	 * @param model - a holder for model attributes
	 * @return html file for presenting the data and input forms
	 */
	@GetMapping("/home")
	public String welcomePage(Model model) {
		
		//Adding member repository for saving members and a new member instance
		model.addAttribute("membersrepo", memberRepo.getRepository().values());
		model.addAttribute("member", new GroupMember());
		
		//html located in templates folder of the project
		return "welcomepage";
	}
	
	
	@PostMapping("/home")
	public String addMember(Model model, @ModelAttribute GroupMember member) {
		
		/*
		 * Since the member name and starting budget are user defined,
		 * we are only left with the task of assigning a unique id
		 */
		member.setId(generator.generateId());
		this.memberRepo.addGroupMember(member);
		
		//The rest is same setup as get mapping
		model.addAttribute("membersrepo", memberRepo.getRepository().values());
		model.addAttribute("member", new GroupMember());
		return "welcomepage";
	}
	
	/**
	 * Returns the page where user is redirected after pressing redirect link on welcome page
	 * @return transaction html page
	 */
	@GetMapping("/transactions")
	public String transactionsPage() {
		return "transactions";
	}
	
}
