package com.expenses.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ErrorHandlerController {

	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ExceptionHandler(Exception.class)
	public ModelAndView respond(){
		String answer = "errorpage";
		return new ModelAndView(answer);
	}
}
