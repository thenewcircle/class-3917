package com.example.pacman;

import javax.sql.DataSource;

public class CustomerService {

	private DataSource ds = JndiHelper.jndiLookup("/jdbc/regionalDS", DataSource.class);
	
	public Object findCustomer() {
		return null;
	}

}
