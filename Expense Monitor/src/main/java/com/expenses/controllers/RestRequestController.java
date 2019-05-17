package com.expenses.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expenses.mockrepository.MemberRepository;

@RestController
public class RestRequestController {
	
	private MemberRepository memberRepo = new MemberRepository();

	@RequestMapping("/home")
	public String welcomePage() {
		return "welcome-page";
	}
}
