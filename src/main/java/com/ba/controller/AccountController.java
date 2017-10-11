package com.ba.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ba.domain.account.Account;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	
	private static List<Account> accounts = new ArrayList<Account>();
	
	static {
		
		accounts.add(new Account("1",1200));
		accounts.add(new Account("2",15000));
		
	}
	
	public AccountController() {
	}
	
	@RequestMapping( method = RequestMethod.GET)
	@ResponseBody
	public List<Account> retrieveAllAccounts() {
		return accounts;
	}
	
	@RequestMapping( method = RequestMethod.GET, value = "/{accountId}")
	@ResponseBody
	public Account retrieveCustomerAccount(@PathVariable String accountId) {
		Optional<Account> account = accounts.stream().filter(p -> p.getAccountId().equalsIgnoreCase(accountId)).findFirst();
		return account.orElse(new Account(accountId,0));
	}

}
