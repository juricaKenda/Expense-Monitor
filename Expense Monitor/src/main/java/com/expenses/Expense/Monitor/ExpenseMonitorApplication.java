package com.expenses.Expense.Monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.expenses")
public class ExpenseMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseMonitorApplication.class, args);
	}

}
