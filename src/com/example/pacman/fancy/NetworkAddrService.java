package com.example.pacman.fancy;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class NetworkAddrService {

	@Autowired()
	@Qualifier("regional")
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	public Object findNetworkAddr() {
		return new Object();
	}
	
}
