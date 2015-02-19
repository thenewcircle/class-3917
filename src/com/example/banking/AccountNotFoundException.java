package com.example.banking;

public class AccountNotFoundException extends Exception {

	private static final long serialVersionUID = 67348410400580845L;
	private final Long accountId;

	public AccountNotFoundException(Long accountId) {
		super(String.format("Account #%d was not found", accountId));
		this.accountId = accountId;
	}

	public Long getAccountId() {
		return accountId;
	}

}
