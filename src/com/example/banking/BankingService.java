package com.example.banking;

public interface BankingService {

	/**
	 * 
	 * @param fromAccountId
	 * @param toAccountId
	 * @param amount
	 * @throws AccountNotFoundException if either account does not exist.
	 */
	void transfer(long fromAccountId, long toAccountId, double amount) throws AccountNotFoundException;

}
