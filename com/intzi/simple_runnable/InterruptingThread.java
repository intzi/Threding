package com.intzi.simple_runnable;

public class InterruptingThread extends Thread{
	
	@Override
	public void run() {
		//If method is interruptible then we get an exception
		//Otherwise Thread.isInterrupted() is set to True
		//E.g. Sleep is interruptible
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			//e.printStackTrace();
			System.out.println("I was interrupted");
		}
	}
}
