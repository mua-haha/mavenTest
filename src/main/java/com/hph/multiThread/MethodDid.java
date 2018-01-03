package com.hph.multiThread;

public class MethodDid {
	Object o = new Object();
	
	public  void doing() throws InterruptedException {
		synchronized (o) {
			Thread.sleep(1000);
			System.out.println("--");
		}
	}

}
