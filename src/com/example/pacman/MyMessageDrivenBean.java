package com.example.pacman;

import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


@MessageDriven
public class MyMessageDrivenBean implements MessageListener {

	@EJB
	MyStatelessWorkerBean worker;
	
	@Override
	public void onMessage(Message message) {
		try {
			String json = ((TextMessage) message).getText();
			RequestMessage request = RequestMessage.parse(json);
			worker.doWork(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
