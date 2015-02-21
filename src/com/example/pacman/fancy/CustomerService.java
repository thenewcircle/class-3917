package com.example.pacman.fancy;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CustomerService {

	@Autowired()
	@Qualifier("regional")
	private DataSource dataSource;

	public Object findCustomers() {
		return null;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}
	
}
