package com.hph.multiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	public static void main(String[] args) {

		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.submit(new TestThread());
		executorService.submit(new TestThread());
		executorService.submit(new TestThread());
		executorService.submit(new TestThread());
		executorService.submit(new TestThread());
		executorService.submit(new TestThread());

		// Thread.start 与 用线程池结果不一样，似乎是 用线程池 绕过了 synchronized
		// 为什么？

		// TestThread t = new TestThread();
		// new Thread(t).start();
		// new Thread(t).start();
		// new Thread(t).start();
		// new Thread(t).start();
	}
	public static void main(String[] args,String a) {

		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.submit(new TestThread());
		executorService.submit(new TestThread());
		executorService.submit(new TestThread());
		executorService.submit(new TestThread());
		executorService.submit(new TestThread());
		executorService.submit(new TestThread());

		// Thread.start 与 用线程池结果不一样，似乎是 用线程池 绕过了 synchronized
		// 为什么？

		// TestThread t = new TestThread();
		// new Thread(t).start();
		// new Thread(t).start();
		// new Thread(t).start();
		// new Thread(t).start();
	}
	
}

class TestThread implements Runnable {

	public void run() {
		sale();
	}

	public void sale() {
		synchronized (this.getClass()) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println(Thread.currentThread().getName() + " is done");
		}
	}
}
