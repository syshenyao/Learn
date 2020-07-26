package com.yss.ams.juc.c_002;

import java.util.concurrent.Exchanger;

public class T12_TestExchanger {
	static Exchanger<String> exchanger=new Exchanger<String>();
	public static void main(String[] args) {
		new Thread(()->{
			String s="T1";
			try {
				s=exchanger.exchange(s);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" "+s);
		},"t1").start();
		
		new Thread(()->{
			String s="T2";
			try {
				s=exchanger.exchange(s);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" "+s);
		},"t2").start();
		
		
	}

}
