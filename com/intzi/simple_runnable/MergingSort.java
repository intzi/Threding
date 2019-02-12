package com.intzi.simple_runnable;


// NOT WORKING
public class MergingSort {
	
	private int[] elements;
	
	public MergingSort(int[] elements) {
		this.elements = elements;
	}
	
	public int[] sort() {
		
		int threadCounter = 0;
		
		MyThread[] threads = new MyThread[10];
		
		for(int i = 0; i < elements.length; i++) {
			
			if(i % 4 == 0 && i!= 0) {
				System.out.println("I: "+i+" i-4: "+(i-4));
				threads[threadCounter++] = new MyThread(i-4, i);
			}

		
		}
		
		for(MyThread thread : threads) {
			if(thread != null) {
				thread.start();				
			}
		}
		
		for(MyThread thread : threads) {
			if(thread != null) {
				try {
					thread.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		}
		
		return elements;
	}
	
	class MyThread extends Thread{
		
		private int startIndex;
		private int endIndex;
		
		public MyThread(int startIndex, int endIndex) {
			this.startIndex = startIndex;
			this.endIndex = endIndex;
		}
		
		@Override
		public void run() {
			sort(elements);
		}
		
		
		public int[] sort(int[] elements) {
			
			while(true) {
				boolean sorted = true;
				
				
				for (int i = startIndex; i < endIndex-1; i++) {
					int nextElement = i+1;
					if(elements[i] > elements[nextElement]) {
						sorted = false;
						int temp = elements[i]; 
						elements[i] = elements[nextElement]; 
						elements[nextElement] = temp;
					}
				}
				
				
				if(sorted)
					break;
			}
			
			return elements;
		}
		
	}
}



