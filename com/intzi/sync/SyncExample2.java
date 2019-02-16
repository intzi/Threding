package com.intzi.sync;

import java.util.ArrayList;
import java.util.Random;

public class SyncExample2 implements Runnable{
	
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();
	
	
	private static ArrayList<Integer> list1 = new ArrayList<>();
	private static ArrayList<Integer> list2 = new ArrayList<>();
	private static Random r = new Random();
	
	@Override
	public void run() {
		for(int i = 0; i < 1000; i++) {
			task1();
			task2();
		}
	}
	
	public static void task1() {
		
		synchronized(lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list1.add(r.nextInt(100)+1);
			
		}
	}
	
	public synchronized static void task2() {
		
		synchronized(lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list2.add(r.nextInt(100)+1);
		}
	}
	
	public ArrayList<Integer> getList1() {
		return list1;
	}
	
	public ArrayList<Integer> getList2() {
		return list2;
	}
	
}
