package com.expenses.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expenses.mockrepository.MemberRepository;

@RestController
public class RestRequestController {
	
	@Autowired
	private MemberRepository memberRepo;

	@RequestMapping("/home")
	public String welcomePage() {
		return "welcome-page";
	}
}
