package com.example.pacman;

import javax.sql.DataSource;

public class NetworkAddrService {

	private DataSource ds = JndiHelper.jndiLookup("/jdbc/regionalDS", DataSource.class);
	
	public Object getNetworkAddr() {
		return null;
	}

}
