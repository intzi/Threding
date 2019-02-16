package com.intzi.swing_countdown;

import java.util.concurrent.CountDownLatch;

public class CountDown implements Runnable{
	
	private CountDownLatch cdl;
	
	public CountDown(CountDownLatch cdl) {
		this.cdl = cdl;
	}

	@Override
	public void run() {
		System.out.println("Started..");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		decreaseCdl();
		decreaseCdl();
		decreaseCdl();
		
	}
	
	public void decreaseCdl() {
		cdl.countDown();
	}
}
