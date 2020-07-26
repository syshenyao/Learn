package com.yss.ams.suspendThread;

public class Run {

	static class MyThread extends Thread {
		private Object lock = new Object();
		private volatile boolean pause = false;
		private volatile boolean stop = false;
		void pauseThread() {
			pause = true;
		}
		
		void stopThread() {
			stop = true;
		}

		void resumeThread() {
			pause = false;
			synchronized (lock) {
				lock.notify();
			}
		}

		void onPause() {
			synchronized (lock) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		@Override
		public void run() {
			super.run();
			int index = 0;
			while (!stop) {
				while (pause) {
					onPause();
				}

				try {
					System.out.println(index);
					Thread.sleep(50);
					index++;
				} catch (InterruptedException e) {
					e.printStackTrace();
					break;
				}

			}

		}
	}

	public static void main(String[] args) {
			MyThread myThread=new MyThread();
			Thread thread=new Thread(myThread);
			thread.start();
			try {
				Thread.sleep(1000);
				myThread.pauseThread();
				Thread.sleep(5000);
				myThread.resumeThread();
				Thread.sleep(5000);
				myThread.stopThread();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}
