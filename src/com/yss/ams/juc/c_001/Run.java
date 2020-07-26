package com.yss.ams.juc.c_001;

public class Run {

	public static void main(String[] args) throws InterruptedException {
		MyService myService = new MyService();
		long start=System.currentTimeMillis();
		ThreadAA threadAA = new ThreadAA(myService);
		ThreadBB threadBB = new ThreadBB(myService);
		ThreadCC threadCC = new ThreadCC(myService);
		threadAA.start();
		threadBB.start();
		threadCC.start();
		threadAA.join();
		threadBB.join();
		threadCC.join();
		long end=System.currentTimeMillis();
		System.out.println(end-start);
	}

}
