package com.example.pacman;

import javax.jms.ConnectionFactory;

public class JmsService {

	ConnectionFactory jmsConnectionFactory;

	
	public void setJmsConnectionFactory(ConnectionFactory jmsConnectionFactory) {
		this.jmsConnectionFactory = jmsConnectionFactory;
	}

	public void sendMessage(String customer, String message) {
		
	}

}
