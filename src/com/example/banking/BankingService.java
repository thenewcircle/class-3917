package com.example.banking;

public interface BankingService {

	void transfer(long fromAccountId, long toAccountId, double amount) throws AccountNotFoundException;

}
