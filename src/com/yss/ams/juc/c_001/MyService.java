package com.yss.ams.juc.c_001;

public class MyService {
	private volatile int orderNum =1 ;
	
	public synchronized void methodA(){
		try {
			while(orderNum !=1){
				wait();
			}
			for (int i = 0; i < 2; i++) {
				System.out.println("AAAA");
			}
			orderNum = 2;
			notifyAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void methodB(){
		try {
			while(orderNum !=2){
				wait();
			}
			for (int i = 0; i < 2; i++) {
				System.out.println("BBBB");
			}
			orderNum = 3;
			notifyAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void methodC(){
		try {
			while(orderNum !=3){
				wait();
			}
			for (int i = 0; i < 2; i++) {
				System.out.println("CCCC");
			}
			orderNum = 1;
			notifyAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
