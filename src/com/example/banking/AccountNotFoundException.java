package com.example.banking;

public class AccountNotFoundException extends Exception {

	private final Long accountId;
	
	
	
	public AccountNotFoundException(Long accountId) {
		super("Account #1 was not found");
		this.accountId = accountId;
	}



	public Long getAccountId() {
		return accountId;
	}

}
