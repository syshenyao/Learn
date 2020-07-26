package com.yss.ams.wait;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WaitNotify {
	static boolean flag = true;
	static Object lock = new Object();

	public static void main(String[] args) throws InterruptedException {
		Thread waitThread = new Thread(new Wait(), "WaitThread");
		waitThread.start();
		TimeUnit.SECONDS.sleep(10);
		Thread notifyThread = new Thread(new Notify(), "NotifyThread");
		notifyThread.start();
	}

	static class Wait implements Runnable {

		@Override
		public void run() {
			synchronized (lock) {
				while (flag) {
					try {
						System.out.println(Thread.currentThread()
								+ " flag is true. wait @"
								+ new SimpleDateFormat("HH:mm:ss")
										.format(new Date()));
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}

				System.out.println(Thread.currentThread()
						+ " flag is false. running @"
						+ new SimpleDateFormat("HH:mm:ss").format(new Date()));
			}
		}

	}

	static class Notify implements Runnable {

		@Override
		public void run() {
			synchronized (lock) {

				try {
					System.out.println(Thread.currentThread()
							+ " hold lock. notify @"
							+ new SimpleDateFormat("HH:mm:ss")
									.format(new Date()));
					lock.notifyAll();
					flag = false;
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			synchronized (lock) {

				try {
					System.out.println(Thread.currentThread()
							+ " hold lock again. notify @"
							+ new SimpleDateFormat("HH:mm:ss")
									.format(new Date()));
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
