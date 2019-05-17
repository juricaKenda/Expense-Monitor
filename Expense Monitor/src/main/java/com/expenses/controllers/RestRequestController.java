package com.expenses.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestRequestController {

	@RequestMapping("/home")
	public String welcomePage() {
		return "Welcome";
	}
}
