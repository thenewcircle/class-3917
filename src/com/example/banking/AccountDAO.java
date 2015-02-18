package com.example.banking;

public interface AccountDAO {

	/**
	 * Creates a new account in the database.  The database will assign it
	 * a unique id.
	 */
	Account create(String owner, double balance);

	/**
	 * Retreives the account from the database with the given primary key.
	 */
	Account find(long id);

}
