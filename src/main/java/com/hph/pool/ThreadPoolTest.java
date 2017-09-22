package com.hph.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.hph.socket.TestRanqi;

public class ThreadPoolTest {
	
	public static void main(String[] args){
		ExecutorService singleThreadExecutor = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 20; i++) {
			final int index = i;
			singleThreadExecutor.execute(new Runnable() {

				@Override
				public void run() {
					System.out.println(index);
					try {
						TestRanqi.queryArrearage();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		
	}

}
