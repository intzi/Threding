package com.intzi.exercises;

import java.util.Random;


public class MaxNumbers {
	
	private int[][] arr2d;
	
	public MaxNumbers(int rows, int cols) {
		MakeRandArray mra = new MakeRandArray(rows, cols);
		arr2d = mra.getArray();
		mra.print();
		
	}
	
	public int[] start() {

		int[] resArr = new int[arr2d.length];
		Thread[] threads = new Thread[arr2d.length];
		
		System.out.println();
		System.out.print("Threads Completed: ");
		for(int i = 0; i < arr2d.length; i++) {
			threads[i] = new Thread(new MyRunnable(arr2d[i], resArr));
			threads[i].start();
		}
		
		for(int i = 0; i < arr2d.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println();
		System.out.println();
		
		return resArr;
	}
	
	

}


class MyRunnable implements Runnable{
	
	private static int _ID = -1;
	private int thisID;
	private int[] arr;
	private int[] arrRow;
	
	public MyRunnable(int[] arrRow, int[] arr) {
		thisID = ++_ID;
		this.arrRow = arrRow;
		this.arr = arr;
		
	}
	
	@Override
	public void run() {
		
		
		int max = 0;
		for(int i : arrRow) {
			if(i > max)
				max = i;
		}
		arr[thisID] = max;
	
		System.out.print(thisID+" ");
		
	}
	
	public long getId() {
		return _ID;
	}
}

class MakeRandArray {
	
	int[][] array;
	
	public MakeRandArray(int rows, int cols) {
		array = make2d(rows, cols);
	}
	
	public int[][] make2d(int rows, int cols){
		
		int[][] array = new int[rows][cols];
		Random r = new Random();
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				array[i][j] = r.nextInt(100)+1;
			}
		}
		
		return array;
	}
	
	public int[][] getArray(){
		return array;
	}
	
	public void print() {
		for(int i = 0; i < array.length; i++) {
			System.out.print("Row: "+i+" (");
			for(int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println(") ");
		}
	}
}