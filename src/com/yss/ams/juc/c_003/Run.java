package com.yss.ams.juc.c_003;

public class Run {

	public static void main(String[] args) throws InterruptedException {
		MyService myService = new MyService();
		long start=System.currentTimeMillis();
		ThreadBB output = new ThreadBB(myService);
		output.start();
		ThreadAA input = new ThreadAA(myService);
		input.start();
		ThreadCC threadCC = new ThreadCC(myService);
		threadCC.start();
		output.join();
		input.join();
		threadCC.join();
		long end=System.currentTimeMillis();
		System.out.println(end-start);
	}

}
