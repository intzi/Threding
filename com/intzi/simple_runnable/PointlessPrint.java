package com.intzi.simple_runnable;

public class PointlessPrint implements MyRunnable{
	
	private String message;
	private int count;
	
	public PointlessPrint(String message, int count) {
		this.message = message;
		this.count = count;
	}

	@Override
	public void run() {
		for(int i = 0; i < count; i++) {
			System.out.println("Message: "+message+" Count: "+(i+1));
		}
	}

	
}
