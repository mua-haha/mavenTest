package com.hph.multiThread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BatchThreadPool {
	private BlockingQueue<Runnable> workQueue;
	
	public BlockingQueue<Runnable> getWorkQueue() {
		return workQueue;
	}

	public void setWorkQueue(BlockingQueue<Runnable> workQueue) {
		this.workQueue = workQueue;
	}

	public static ThreadPoolExecutor getThreadpoolexecutor() {
		return threadPoolExecutor;
	}
	
	private static ThreadPoolExecutor threadPoolExecutor;
	
	public BatchThreadPool(Integer corePoolSize, Integer maximumPoolSize, Long keepAliveTime) {
		workQueue = new ArrayBlockingQueue<>(100);
		threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, workQueue);
	}
	
	public Integer getQueueSize() {
		return workQueue.size();
	}
	
	public void commit(Runnable job) {
		threadPoolExecutor.execute(job);
	}
}
