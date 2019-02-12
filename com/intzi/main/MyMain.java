package com.intzi.main;

import com.intzi.simple_runnable.ExtendingThread;
import com.intzi.simple_runnable.InterruptingThread;
import com.intzi.simple_runnable.MergingSort;
import com.intzi.simple_runnable.PointlessPrint;

public class MyMain {
	public static void main(String[] args) {
		
		System.err.println("Main Start");

		// Threads in Java can be used either by implementing a Runnable interface
		// Or by extending the Thread Class
		
		// ~~~ Swing Count Down ~~~
		/*
			new Test();
		*/
		
		
		// ~~~ Single Thread ~~~
		/*
			PointlessPrint p = new PointlessPrint("Hello message", 20);
			Thread t = new Thread((Runnable)p);
			t.start();
		*/
		
		// ~~~ Threads Array ~~~
		/*
			Thread[] threads = new Thread[2];
			int counter = 0;
			for(Thread t : threads) {
				threads[counter] = new Thread(new PointlessPrint("Tread: "+counter, 10));
				threads[counter++].start();
			}
		*/
		
		
		// ~~~ Threads will start here. They will sleep for 5sec. ~~~
		/*
			for(int i = 0; i < 3; i++) {
				new ExtendingThread().start();
			}
		*/
		
		
		// ~~~ Thread Interruption ~~~
		/*
			InterruptingThread it = new InterruptingThread();
			it.start();
			it.interrupt();
		*/
		
		// ~~~ Thread Join ~~~
		/*
			Thread[] threads = new Thread[5];
			
			for(int i = 0; i < threads.length; i++) {
				threads[i] = new Thread(new InterruptingThread());
				threads[i].start();
				//If we add join here
				//The Program will wait in each loop
				//Bad Idea. That way the program is not executing concurrently.
			}
			
			//Join here will wait until all threads are finished
			//And main will finish last
			
			for(int i = 0; i < threads.length; i++) {
				try {
					threads[i].join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		*/
		
		// ~~~ Merging Sort ~~~ NOT WORKING
		/*
			int[] array = {2,1,4,4,23,42,1,765,32,54,12,75,3,88,5,2,366,123};
			MergingSort ms = new MergingSort(array);
			int[] sortedArray = ms.sort();
			
			for(int elem : sortedArray) {
				System.out.println("Elem: "+elem);
			}
			
			System.err.println("Main End");
		*/
		
	}
	
}
