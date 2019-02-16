package com.intzi.sync;

public class SyncExample extends Thread {

	private static int count = 0;
	
	private static synchronized void increament() {
		count++;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10000; i++) {
			increament();
		}
	}
	
	public int getCount() {
		return count;
	}
	
}