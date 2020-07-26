package com.yss.ams.juc.c_003;

public class MyService {
	private volatile int orderNum =1 ;
	
	public  void methodA(){
			for (int i = 0; i < 2; i++) {
				System.out.println("AAAA");
			}
			orderNum = 2;
	}
	
	public  void methodB(){
		
			while(orderNum !=2);
			for (int i = 0; i < 2; i++) {
				System.out.println("BBBB");
			}
			orderNum = 3;
			
	}
	
	public  void methodC(){
			while(orderNum !=3);
			for (int i = 0; i < 2; i++) {
				System.out.println("CCCC");
			}
	}
}
