package com.yss.ams.testWaitInterruptException;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;




public class Test {
	private static Object object=new Object();
	public static void main(String[] args) {
	  final Map<String, String> map=new HashMap<String, String>();
	  for (int i = 0; i < 100; i++) {
		  map.put("key"+i, "value"+i);
	  }
	  
	  ExecutorService exec=Executors.newFixedThreadPool(10);
	  for (int i = 0; i < 10; i++) {
		  exec.execute(new Runnable() {
				@Override
				public void run() {
					synchronized (object) {
						if(!map.containsKey("key155")){
							System.out.println("11111111");
							map.put("key155", "key155");
						}
					}
					
				}
			}); 
	  }
	
	  
	  exec.shutdown();
	}
	
}
