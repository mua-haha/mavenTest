package com.hph.multiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessageSender {
	private ExecutorService executorService = Executors.newCachedThreadPool();
	MethodDOImpl methodDOImpl = new MethodDOImpl();

	public void send() {

		executorService.execute(new Runnable() {

			@Override
			public void run() {
				methodDOImpl.doing();
				// MethodDid m = new MethodDid();
				// m.doing();
				// doing();
			}

		});
	}

}
