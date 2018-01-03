package com.hph.multiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Increment implements Runnable {
	public static int a = 0;

	public synchronized void increment() {
		a++;
	}

	public void run() {
		increment();
	}

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 1000; i++) {
			exec.execute(new Increment());
		}
		try {
			TimeUnit.SECONDS.sleep(10);
			System.out.println(a);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
