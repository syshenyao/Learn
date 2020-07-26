package com.yss.ams.testWaitInterruptException;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Run {
	ReentrantLock lock = new ReentrantLock();
    Condition firstCondition = lock.newCondition();
    Condition secondCondition = lock.newCondition();
    Condition thirdCondition = lock.newCondition();
    int state = 1;
    
	 public void first() throws InterruptedException {
	        lock.lock();
	        try{
	            // printFirst.run() outputs "first". Do not change or remove this line.
	            if(state!=1){
	            	System.out.println("wait First()!");
	                firstCondition.await();
	            }
	            state = 2;
	            System.out.println("run First()!");
	            secondCondition.signal();
	        }finally {
	            lock.unlock();
	        }
	        
	    }

	    public void second() throws InterruptedException {
	        lock.lock();
	        try{
	          //  if(state!=2){
	            	 System.out.println("wait Second()!");
	                secondCondition.await();
	           // }
	            state = 3;
	            System.out.println("run Second()!");

	            thirdCondition.signal();
	             // printSecond.run() outputs "second". Do not change or remove this line. 
	        }finally{
	            lock.unlock();
	        }
	    }

	public static void main(String[] args) throws InterruptedException {
		final Run run=new Run();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					run.first();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		TimeUnit.SECONDS.sleep(3);
		run.second();
		

	}

}
