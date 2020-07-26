package com.yss.ams.juc.c_004;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class T03_NotifyHoldingLock {
	volatile List lists = new ArrayList<Object>();

	public void add(Object o) {
		lists.add(o);
	}

	public int size() {
		return lists.size();
	}

	public static void main(String[] args) {
		T03_NotifyHoldingLock c = new T03_NotifyHoldingLock();
		final Object lock = new Object();
		new Thread(() -> {
			synchronized (lock) {
				System.out.println("t2 启动");
				if (c.size() != 5) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("t2 结束");
				lock.notify();
			}
			
		}, "t2").start();

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		new Thread(() -> {
			System.out.println("t1 启动");
			synchronized (lock) {
				for (int i = 0; i < 10; i++) {
					c.add(new Object());
					System.out.println("add " + i);
					if (c.size() == 5) {
						lock.notify();
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}, "t1").start();

	}

}
