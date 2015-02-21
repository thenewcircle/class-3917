package com.example.pacman.fancy;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class RequestMessageLogService {
	
	@Autowired
	@Qualifier("regional")
	private DataSource dataSource;
	
	public void logValidationErrors(List<ValidationError> errors) {
		//Pretend I went to the database
	}

	public void setDataSource(DataSource datasource) {
		this.dataSource = datasource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}
}
