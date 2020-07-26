package com.yss.ams.testCurrentThreadMethod;

public class CountOperate extends Thread {
	public CountOperate() {
		super();
		System.out.println("CountOperate----begin");
		System.out.println("Thread.currentThread().getName()="+Thread.currentThread().getName());
	}
	@Override
	public void run() {
		//super.run();
	}

}
