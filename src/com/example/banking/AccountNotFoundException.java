package com.example.banking;

public class AccountNotFoundException extends Exception {

	private final Long accountId;
	
	
	
	public AccountNotFoundException(Long accountId) {
		super(String.format("Account #%d was not found", accountId));
		this.accountId = accountId;
	}



	public Long getAccountId() {
		return accountId;
	}

}
