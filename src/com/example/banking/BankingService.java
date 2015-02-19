package com.example.banking;

public interface BankingService {

	/**
	 * 
	 * @param fromAccountId
	 * @param toAccountId
	 * @param amount
	 * @throws AccountNotFoundException
	 *             if either account does not exist.
	 * @throws InsufficientBalanceException
	 *             if the target account lacks funds.
	 */
	void transfer(long fromAccountId, long toAccountId, double amount)
			throws AccountNotFoundException, InsufficientBalanceException;

}
