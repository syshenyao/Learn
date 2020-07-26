package com.yss.ams.testCurrentThreadMethod;

import java.util.concurrent.TimeUnit;

public class Run {

	public static void main(String[] args) throws InterruptedException {
		MyThread  myThread=new MyThread();
		myThread.start();
		TimeUnit.MILLISECONDS.sleep(1);
		Thread.currentThread().interrupt();
		System.out.println(myThread.isInterrupted());
		System.out.println(myThread.isInterrupted());
		
	}
	
	static class MyThread extends Thread{
		
		@Override
		public void run() {
			super.run();
			for (int i = 0; i < 1000; i++) {
				System.out.println(i);
			}
		}
	}

}
