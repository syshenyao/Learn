package com.yss.ams.juc.c_000;

public class T03_Sleep_Yield_Join {
	public static void main(String[] args) {
		testJoin();
	}

	private static void testJoin() {
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("A" + i);
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(() -> {
			try {
				t1.join();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			for (int i = 0; i < 10; i++) {
				System.out.println("A" + i);
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();
	}
}
