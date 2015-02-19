package com.example.banking;

import java.util.HashMap;
import java.util.Map;

public class InMemoryAccountDAO implements AccountDAO {

	private static final AccountDAO instance = new InMemoryAccountDAO();

	public static AccountDAO getInstance() {
		return instance;
	}

	private long nextId = 1;
	private Map<Long,Account> database = new HashMap<>();

	public InMemoryAccountDAO() {
	}
	
	@Override
	public Account create(String owner, double balance) {
		long id = nextId;
		nextId ++;
		Account account = new Account(id, owner, balance);
		database.put(id, account);
		return account;
	}

	@Override
	public Account find(long id) throws AccountNotFoundException {
		if (database.containsKey(id) == false) {
			throw new AccountNotFoundException(id);
		}
		return database.get(id);
	}

	@Override
	public void update(Account account) {
		long id = account.getId();
		database.put(id, account);
	}

}
