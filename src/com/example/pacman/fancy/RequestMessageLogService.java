package com.example.pacman.fancy;

import java.util.List;

import javax.sql.DataSource;

public class RequestMessageLogService {
	
	private DataSource dataSource;
	
	public void logValidationErrors(List<ValidationError> errors) {
		//Pretend I went to the database
	}

	public void setDatasource(DataSource datasource) {
		this.dataSource = datasource;
	}
	
}
