package com.intzi.pool;

public class ThreadPool implements Runnable{
	
	private int id;
	
	public ThreadPool(int id) {
		this.id = id;
	}

	
	public void run() {
		
		System.out.println("Thread: "+id+" Started!");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Thread: "+id+" Completed!");
	}
	
	
}
