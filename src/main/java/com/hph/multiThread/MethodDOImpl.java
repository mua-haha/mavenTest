package com.hph.multiThread;

public class MethodDOImpl implements MethodDO {

	public static int i = 0;

	@Override
	public synchronized void doing() {
		System.out.println(i++);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void doing1() throws InterruptedException {
		System.out.println(i++);
		Thread.sleep(1000);
	}

}
