package com.intzi.sync;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
	
	public ReentrantLockExample() {
		Thread t = new Thread(new MyRunnable(1));
		t.start();

		Thread t2 = new Thread(new MyRunnable(2));
		t2.start();
	}
}

class MyRunnable implements Runnable {

	private int choice;
	private static Lock lock = new ReentrantLock();;
	private static Condition cond = lock.newCondition();
	
	public MyRunnable(int choice) {
		this.choice = choice;
	}
	
	@Override
	public void run() {
		if(choice == 1) {
			process();
		}else {
			pause();
		}
	}
	
	public void process() {
		lock.lock();
		
		System.out.println("Waiting...");
		try {
			cond.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println("Doing...");
		} finally {
			lock.unlock();
		}
	}
	
	public void pause() {
		//Sleep 4sec
		try {
			Thread.sleep(4000);
			lock.lock();
			System.out.println("Press any key: ");
			Scanner s = new Scanner(System.in);
			s.nextLine();
			s.close();
			cond.signal();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println("Doing2...");
		} finally {
			lock.unlock();
		}
	}
	
}