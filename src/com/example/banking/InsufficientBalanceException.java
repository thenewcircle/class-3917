package com.example.banking;

public class InsufficientBalanceException extends Exception {

	private static final long serialVersionUID = -1272020798361903410L;
	private final Long accountId;
	private final double accountBalance;
	private final double withdrawAmount;

	public InsufficientBalanceException(Account account, double withdrawAmount) {
		super(String.format("Unable to withdraw $%.2f from %s", withdrawAmount, account));
		this.accountId = account.getId();
		this.accountBalance = account.getBalance();
		this.withdrawAmount = withdrawAmount;
	}

	public Long getAccountId() {
		return accountId;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public double getWithdrawAmount() {
		return withdrawAmount;
	}

}
