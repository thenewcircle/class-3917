package com.example.pacman;

import javax.sql.DataSource;

public class SecurityService {

	private DataSource dataSource;

	/** Injects the datasource */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void checkSecurity() {}
	
}
