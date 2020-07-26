package com.yss.ams.juc.c_002;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class T05_ReentrantLock5 extends Thread {
	 ReentrantLock lock= new ReentrantLock(false);
	@Override
	public void run() {
		
		for (int i = 0; i < 100; i++) {
			lock.lock();
			try {
				System.out.println(Thread.currentThread().getName()+"获得锁");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				lock.unlock();
			}
			
		}
	}

	public static void main(String[] args) {
		T05_ReentrantLock5 r1= new T05_ReentrantLock5();
		ExecutorService executorService=Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			executorService.execute(r1);
		}
		executorService.shutdown();
	}

}
