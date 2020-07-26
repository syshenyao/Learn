package com.yss.ams;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestContain extends Thread {
	private static Lock lock = new ReentrantLock();
	private final String key = "key";

	private final static ConcurrentMap<String, Object> locks = new ConcurrentHashMap<String, Object>();

	private static Object getLock(String lockName) {
		if (!locks.containsKey(lockName)) {
			locks.putIfAbsent(lockName, new String("我是值"));
			System.out.println("加了一次");
		}
		return locks.get(lockName);
	}

	@Override
	public void run() {
		lock.lock();
		try {
			getLock(this.key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			new TestContain().start();
		}
	}
}