package com.example.pacman.fancy;

import javax.sql.DataSource;

public class NetworkAddrService {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public Object findNetworkAddr() {
		return new Object();
	}
	
}
