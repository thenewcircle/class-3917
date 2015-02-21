package com.example.pacman.fancy;

import javax.annotation.Resource;

public class MyMessageDrivenBean {

	@Resource(name="/ejb/worker")
	private MyStatelessWorkerBean worker;
	
	public void onMessage(Object msg) {
		String json = String.valueOf(msg);
		Object data = json;
		worker.doWork(data);
	}
	
}
