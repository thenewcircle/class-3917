package com.example.pacman;

import javax.sql.DataSource;

public class RequestMessageLogService {

	private DataSource dataSource;

	/** Injects the datasource */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void log(ValidationError e) {
		
	}
	
	
}
