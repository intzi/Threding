package com.intzi.sync;

import java.util.Scanner;

public class WaitNotify{
	
	public WaitNotify() {
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				process();
			}
		}).start();
		
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				regainControll();
			}
		}).start();
	
	}
	
	private void process() {
		synchronized (this) {
			try {
				System.out.println("Process Start");
				for(int i=1; i<= 10; i++) {
					System.out.println("I: "+i);
					Thread.sleep(500);
				}
				System.out.println("Process Pause");
				wait();
				for(int i=10; i > 0; i--) {
					System.out.println("I: "+i);
					Thread.sleep(500);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Process Done!");
			
		}
	}
	
	
	private void regainControll() {
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner s = new Scanner(System.in);
		System.out.println("Please any key to notify();");
		s.nextLine();
		synchronized (this) {
			notify();				
		}
	}
}
