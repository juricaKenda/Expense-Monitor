package com.expenses.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.expenses.mockrepository.MemberRepository;

@Controller
public class RestRequestController {
	
	private MemberRepository memberRepo = new MemberRepository();

	@RequestMapping("/home")
	public String welcomePage() {
		return "welcomepage";
	}
}
