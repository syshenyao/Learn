package com.yss.ams.juc.c_003;

public class ThreadBB extends Thread {
	private MyService myService;

	
	public ThreadBB(MyService myService) {
		super();
		this.myService = myService;
	}


	@Override
	public void run() {
		myService.methodB();
	}

}
