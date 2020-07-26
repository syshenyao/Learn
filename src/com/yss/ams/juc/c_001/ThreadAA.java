package com.yss.ams.juc.c_001;

public class ThreadAA extends Thread {
	private MyService myService;

	
	public ThreadAA(MyService myService) {
		super();
		this.myService = myService;
	}


	@Override
	public void run() {
		myService.methodA();
	}

}
