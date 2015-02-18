package com.example.banking;

public interface BankingService {

	void transfer(AccountDAO dao, long fromAccountId, long toAccountId,
			double amount);

}
