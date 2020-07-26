package com.yss.ams.juc.c_002;

public class T06_TestCountDownLatch {

	public static void main(String[] args) {
		usingJoin();
	}

	private static void usingJoin() {
		Thread[] threads = new Thread[10];
		for (int i=0 ;i <threads.length;i++) {
			threads[i] = new Thread(() -> {
				int result = 0;
				for (int j = 0; j < 10000; j++) {
					result += j;
				}
				System.out.println(result);
			});

		}
		for (Thread thread : threads) {
			thread.start();
		}
//		for (Thread thread : threads) {
//			try {
//				thread.join();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
	}

}
