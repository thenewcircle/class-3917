package com.example.pacman;

import javax.sql.DataSource;

public class CustomerService {

	private DataSource dataSource;

	/** Injects the datasource */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public Object findCustomer() {
		return null;
	}

}
