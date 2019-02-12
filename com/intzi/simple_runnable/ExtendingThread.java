package com.intzi.simple_runnable;

public class ExtendingThread extends Thread{
	
	private static int _threadID = 0;
	
	public ExtendingThread() {
		this.setName(Integer.toString(_threadID++));
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread: "+this.getName()+" finished");
	}
}
