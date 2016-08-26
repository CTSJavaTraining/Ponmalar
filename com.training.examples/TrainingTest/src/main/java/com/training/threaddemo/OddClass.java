package com.training.threaddemo;

import java.util.*;

public class OddClass extends Thread {

	List<Integer> numbers = new ArrayList<Integer>();
	int i;

	public void run() {
		try {
			printOdd();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public void printOdd() throws InterruptedException {
		synchronized (numbers) {

			for (int i = 1; i < 10; i++) {
				if(i%2==0){
				System.out.println(i);
				numbers.wait();
				}
				else
				{	
				numbers.notifyAll();
				}
			}
			Thread.sleep(1000);
			
		}
	}
}
